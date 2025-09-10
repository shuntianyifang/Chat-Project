package com.github.shuntianyifang.chatproject.handler;

import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.result.AjaxResult;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(50)
public class CustomExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public AjaxResult<Object> handleApiException(ApiException e) {
        return AjaxResult.fail(e.getErrorCode(), e.getErrorMsg());
    }
}
