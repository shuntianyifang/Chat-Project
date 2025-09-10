package com.github.shuntianyifang.chatproject.result;

import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class AjaxResult<T> {
    public static final String SUCCESS_MSG = "success";
    private Integer code;
    private String msg;
    private T data;

    public static <N> AjaxResult<N> success() {
        return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MSG, null);
    }

    public static <N> AjaxResult<N> success(N data) {
        return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MSG, data);
    }

    public static <N> AjaxResult<N> fail(Integer code, String msg) {
        return new AjaxResult<>(code, msg, null);
    }

    public static <N> AjaxResult<N> fail(ExceptionEnum e) {
        return fail(e.getErrorCode(), e.getErrorMsg());
    }
}