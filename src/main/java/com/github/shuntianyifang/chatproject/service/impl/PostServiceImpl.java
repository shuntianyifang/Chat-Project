package com.github.shuntianyifang.chatproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.dto.response.GetPostDetailResponse;
import com.github.shuntianyifang.chatproject.dto.response.GetPostListElement;
import com.github.shuntianyifang.chatproject.entity.Post;
import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.mapper.PostMapper;
import com.github.shuntianyifang.chatproject.service.PostService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    @Override
    public void publishPost(Integer userId, @NotBlank String content) {
        Post post = Post.builder()
                .userId(userId)
                .content(content)
                .viewCount(0)
                .likeCount(0)
                .deleted(false)
                .build();
        postMapper.insert(post);
    }

    @Override
    public void deletePost(Integer userId, Integer postId) {
        Post post = postMapper.selectById(postId);
        if (post == null) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }
        if (!post.getUserId().equals(userId)) {
            throw new ApiException(ExceptionEnum.PERMISSION_NOT_ALLOWED);
        }
        postMapper.deleteById(postId);
    }

    @Override
    public void updatePost(Integer userId, Integer postId, String content) {
        Post post = postMapper.selectById(postId);
        if (post == null) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }
        if (!post.getUserId().equals(userId)) {
            throw new ApiException(ExceptionEnum.PERMISSION_NOT_ALLOWED);
        }
        post.setContent(content);
        postMapper.updateById(post);
    }

    @Override
    public List<GetPostListElement> getAllPosts() {
        LambdaQueryWrapper<Post> postQueryWrapper = new LambdaQueryWrapper<Post>()
                .orderByDesc(Post::getCreatedAt);
        List<Post> list = postMapper.selectList(postQueryWrapper);
        return list.stream()
                .map(post -> GetPostListElement.builder()
                        .postId(post.getPostId())
                        .content(post.getContent())
                        .userId(post.getUserId())
                        .createdAt(post.getCreatedAt())
                        .updatedAt(post.getUpdatedAt())
                        .build()
                ).toList();
    }

    @Override
    public GetPostDetailResponse getPostDetail(Integer id) {
        Post post = postMapper.selectById(id);
        if (post == null) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }

        GetPostDetailResponse resp = GetPostDetailResponse.builder()
                .content(post.getContent())
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
        postMapper.incrementViewCount(id);
        return resp;
    }
}
