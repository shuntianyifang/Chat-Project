package com.github.shuntianyifang.chatproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetReportResponse {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("post_id")
    private Integer postId;

    @JsonProperty("report_id")
    private Integer reportId;

    private Integer status;

    private String content;

    private String reason;
}
