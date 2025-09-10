package com.github.shuntianyifang.chatproject.service;

import com.github.shuntianyifang.chatproject.dto.response.GetPostDetailResponse;
import com.github.shuntianyifang.chatproject.dto.response.GetPostListElement;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface PostService {
    void publishPost(Integer userId, @NotBlank String content);

    void deletePost(Integer userId, Integer postId);

    void updatePost(Integer userId, Integer postId, String content);

    List<GetPostListElement> getAllPosts();

    GetPostDetailResponse getPostDetail(Integer id);
}
