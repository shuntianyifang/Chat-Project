package com.github.shuntianyifang.chatproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetPostListElement {
    private Integer id;

    private String content;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("create_at")
    private LocalDateTime createdAt;
    @JsonProperty("time")
    private LocalDateTime updatedAt;
}
