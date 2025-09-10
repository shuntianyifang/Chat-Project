package com.github.shuntianyifang.chatproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.dto.request.ReportRequest;
import com.github.shuntianyifang.chatproject.dto.response.GetReportListElement;
import com.github.shuntianyifang.chatproject.dto.response.GetReportResponse;
import com.github.shuntianyifang.chatproject.entity.Post;
import com.github.shuntianyifang.chatproject.entity.Report;
import com.github.shuntianyifang.chatproject.entity.User;
import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.mapper.PostMapper;
import com.github.shuntianyifang.chatproject.mapper.ReportMapper;
import com.github.shuntianyifang.chatproject.mapper.UserMapper;
import com.github.shuntianyifang.chatproject.result.AjaxResult;
import com.github.shuntianyifang.chatproject.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {
    private final ReportMapper reportMapper;
    private final PostMapper postMapper;
    private final UserMapper userMapper;

    @Override
    public void createReport(Integer userId, ReportRequest request) {
        Post post = postMapper.selectById(request.getPostId());
        if (post == null) {
            throw new ApiException(ExceptionEnum.POST_NOT_EXIST);
        }
        Report report = Report.builder()
                .postId(request.getPostId())
                .userId(userId)
                .reason(request.getReason())
                .status(0)
                .build();

        reportMapper.insert(report);
    }

    @Override
    public AjaxResult<Object> approvalReport(Integer userId, Integer reportId, Integer status) {
        Report report = reportMapper.selectById(reportId);
        if (report == null) {
            throw new ApiException(ExceptionEnum.REPORT_NOT_EXIST);
        }

        Report approvalreport = new Report();
        approvalreport.setReportId(reportId);
        approvalreport.setStatus(status);
        reportMapper.updateById(approvalreport);

        if (status == 1) {
            Post post = postMapper.selectById(report.getPostId());
            if (post != null) {
                postMapper.deleteById(post.getId());
                return AjaxResult.success("举报通过，帖子已被删除");
            }
            throw new ApiException(ExceptionEnum.POST_ALREADY_DELATED);
        }
        else if (status == 2) {
            return AjaxResult.success("举报未通过");
        }
        throw new ApiException(ExceptionEnum.APPROVAL_ERROR);
    }

    @Override
    public List<GetReportResponse> getReportByUserId(Integer userId) {
        LambdaQueryWrapper<Report> reportQueryWrapper = new LambdaQueryWrapper<>();
        reportQueryWrapper.eq(Report::getUserId, userId);
        List<Report> reports = reportMapper.selectList(reportQueryWrapper);

        List<Integer> postIds = reports.stream()
                .map(Report::getPostId)
                .collect(Collectors.toList());

        Map<Integer, Post> postMap;
        if (!postIds.isEmpty()) {
            List<Post> posts = postMapper.selectBatchIds(postIds);
            postMap = posts.stream()
                    .collect(Collectors.toMap(Post::getId, Function.identity()));
        } else {
            postMap = new HashMap<>();
        }

        return reports.stream()
                .map(report -> {
                    Post post = postMap.get(report.getPostId());

                    return GetReportResponse.builder()
                            .reportId(report.getReportId())
                            .userId(report.getUserId())
                            .reason(report.getReason())
                            .status(report.getStatus())
                            .postId(report.getPostId())
                            .content(post != null ? post.getContent() : null)
                            .build();
                })
                .collect(Collectors.toList()).reversed();
    }

    @Override
    public List<GetReportListElement> getReportList(Integer userId) {
        LambdaQueryWrapper<Report> reportQueryWrapper = new LambdaQueryWrapper<Report>();

        List<Report> list = reportMapper.selectList(reportQueryWrapper);
        return list.stream()
                .map(report -> {
                    Post post = postMapper.selectById(report.getPostId());
                    User user = userMapper.selectById(report.getUserId());

                    return GetReportListElement.builder()
                            .reportId(report.getReportId())
                            .postId(report.getPostId())
                            .content(post != null ? post.getContent() : null)
                            .reason(report.getReason())
                            .status(report.getStatus())
                            .username(user != null ? user.getUsername() : "未知用户")
                            .build();
                }).toList();
    }

}