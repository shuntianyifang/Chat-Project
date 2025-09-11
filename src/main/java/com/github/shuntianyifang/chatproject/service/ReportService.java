package com.github.shuntianyifang.chatproject.service;

import com.github.shuntianyifang.chatproject.dto.request.ReportRequest;
import com.github.shuntianyifang.chatproject.dto.response.GetReportListElement;
import com.github.shuntianyifang.chatproject.dto.response.GetReportResponse;

import java.util.List;

public interface ReportService {
    void createReport(Integer userId, ReportRequest request);

    void approvalReport(Integer userId, Integer reportId, Integer status);

    List<GetReportListElement> getReportList(Integer userId);

    List<GetReportResponse> getReportByUserId(Integer userId);
}
