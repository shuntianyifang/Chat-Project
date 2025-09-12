package com.github.shuntianyifang.chatproject.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DeletePostRequest {
    @NotNull
    private Integer userId;

    @NotNull
    private Integer postId;
}
