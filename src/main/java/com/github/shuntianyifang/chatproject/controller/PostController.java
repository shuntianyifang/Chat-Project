package com.github.shuntianyifang.chatproject.controller;

import com.github.shuntianyifang.chatproject.dto.request.PublishPostRequest;
import com.github.shuntianyifang.chatproject.dto.request.UpdatePostRequest;
import com.github.shuntianyifang.chatproject.dto.response.BaseListResponse;
import com.github.shuntianyifang.chatproject.dto.response.GetPostListElement;
import com.github.shuntianyifang.chatproject.result.AjaxResult;
import com.github.shuntianyifang.chatproject.service.PostService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/post")
@Slf4j
@Validated
public class PostController {
    @Resource
    private PostService postService;

    @PostMapping
    public AjaxResult<Void> publishPost(@Valid @RequestBody PublishPostRequest request) {
        postService.publishPost(request.getUserId(), request.getContent());
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult<Void> updatePost(@Valid @RequestBody UpdatePostRequest request) {
        postService.updatePost(request.getUserId(), request.getPostId(), request.getContent());
        return AjaxResult.success();
    }

    @DeleteMapping
    public AjaxResult<Void> deletePost(
            @RequestParam("user_id") @NotNull Integer userId,
            @RequestParam("post_id") @NotNull Integer postId) {
        postService.deletePost(userId, postId);
        return AjaxResult.success();
    }

    @GetMapping
    public AjaxResult<BaseListResponse<GetPostListElement>> getAllPosts() {
        return AjaxResult.success(new BaseListResponse<>(postService.getAllPosts()));
    }

    /*
    @GetMapping
    public AjaxResult<GetPostDetailResponse> getPostDetail(@RequestParam("id") @NotNull Integer id) {
    return AjaxResult.success(postService.getPostDetail(id));
    }
    */
}
