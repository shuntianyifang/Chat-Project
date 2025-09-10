package com.github.shuntianyifang.chatproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class UpdatePostRequest {
    @NotNull
    private Integer user_id;

    @NotNull
    private Integer post_id;

    @NotBlank
    private String content;
}
