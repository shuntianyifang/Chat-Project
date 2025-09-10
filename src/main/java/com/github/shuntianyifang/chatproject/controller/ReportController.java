package com.github.shuntianyifang.chatproject.controller;

import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.dto.request.ApprovalReportRequest;
import com.github.shuntianyifang.chatproject.dto.request.ReportRequest;
import com.github.shuntianyifang.chatproject.dto.response.GetReportListElement;
import com.github.shuntianyifang.chatproject.dto.response.GetReportResponse;
import com.github.shuntianyifang.chatproject.dto.response.ReportListResponse;
import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.result.AjaxResult;
import com.github.shuntianyifang.chatproject.service.PostService;
import com.github.shuntianyifang.chatproject.service.ReportService;
import com.github.shuntianyifang.chatproject.util.UserTypeValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;
    private final UserTypeValidator userTypeValidator;
    private final PostService postService;

    @PostMapping("/student/report-post")
    public AjaxResult<Void> reportPost(@Valid @RequestBody ReportRequest request) {
        reportService.createReport(request.getUserId(), request);
        return AjaxResult.success();
    }

    @GetMapping("/student/report-post")
    public AjaxResult<List<GetReportResponse>> getReportsByUserId(
            @RequestParam(value = "user_id") Integer userId) {
        try {
            List<GetReportResponse> reports = reportService.getReportByUserId(userId);
            return AjaxResult.success(reports);
        } catch (Exception e) {
            throw new ApiException(ExceptionEnum.GET_REPORT_FAIL);
        }
    }

    @GetMapping("/admin/report")
    public AjaxResult<ReportListResponse<GetReportListElement>> getReports(
            @RequestParam(value = "user_id", required = false) Integer userId) {
        userTypeValidator.validateAdmin(userId);
        List<GetReportListElement> reportDetails;
        reportDetails = reportService.getReportList(userId);
        return AjaxResult.success(new ReportListResponse<>(reportDetails));
    }

    @PostMapping("/admin/report")
    public AjaxResult<Void> approvalReports(@Valid @RequestBody ApprovalReportRequest request) {
        userTypeValidator.validateAdmin(request.getUserId());
        reportService.approvalReport(request.getUserId(), request.getReportId(), request.getStatus());
        return AjaxResult.success();
    }
}