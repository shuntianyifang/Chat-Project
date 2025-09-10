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
public class ApprovalReportResponse {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("report_id")
    private Integer reportId;

    @JsonProperty("approval")
    private Integer status;
}
