package com.github.shuntianyifang.chatproject.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetReportListElement {
    @JsonProperty("report_id")
    private Integer reportId;
    @JsonProperty("post_id")
    private Integer postId;

    private String reason;

    private String content;

    private Integer status;

    private String username;
}
