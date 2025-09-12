package com.github.shuntianyifang.chatproject.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
public class PublishPostRequest {
    @JsonProperty("user_id")
    private Integer userId;

    @NotBlank
    private String content;
}
