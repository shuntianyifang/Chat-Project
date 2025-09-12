package com.github.shuntianyifang.chatproject.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    INVALID_PARAMETER(200000, "参数错误"),
    RESOURCE_NOT_FOUND(200001, "资源不存在"),
    WRONG_USERNAME_OR_PASSWORD(200002, "用户名或密码错误"),
    PERMISSION_NOT_ALLOWED(200003, "权限不足"),
    NOT_FOUND_ERROR(200404, HttpStatus.NOT_FOUND.getReasonPhrase()),
    SERVER_ERROR(200500, "系统错误, 请稍后重试"),
    WRONG_PASSWORD_SIZE(200504,"密码长度必须在8-16位"),
    WRONG_USERTYPE(200504,"错误的用户类型"),
    USER_ALREADY_EXISTS(200505,"用户名已存在"),
    //WRONG_USERNAME(200506,"用户不存在"),
    //WRONG_PASSWORD(200507,"密码错误"),
    POST_NOT_EXIST(200508,"帖子不存在"),
    USER_NOT_LOGIN(200509,"用户未登录"),
    ACCESS_DENIED(200510,"用户无权限"),
    USER_NOT_EXIST(200511,"用户未存在"),
    REPORT_NOT_EXIST(200512,"举报不存在" ),
    POST_ALREADY_DELATED(200513,"举报对应的帖子已删除"),
    APPROVAL_ERROR(200514, "处理类型错误"),
    GET_REPORT_FAIL(200515,"获取举报信息失败");

    private final Integer errorCode;
    private final String errorMsg;
}
