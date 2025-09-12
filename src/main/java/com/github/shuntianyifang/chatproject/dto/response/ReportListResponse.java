package com.github.shuntianyifang.chatproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportListResponse<G> {
    @JsonProperty("report_list")
    private List<GetReportListElement> reportList;
}
