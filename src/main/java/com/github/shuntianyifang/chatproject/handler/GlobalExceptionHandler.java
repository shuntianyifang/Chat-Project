package com.github.shuntianyifang.chatproject.handler;

import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.result.AjaxResult;
import com.github.shuntianyifang.chatproject.util.HandlerUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(1000)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult<Object> handleGlobalException(Exception e) {
        HandlerUtils.logException(e);
        return AjaxResult.fail(ExceptionEnum.SERVER_ERROR);
    }
}
