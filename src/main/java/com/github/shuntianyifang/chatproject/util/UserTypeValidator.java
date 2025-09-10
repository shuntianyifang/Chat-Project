package com.github.shuntianyifang.chatproject.util;

import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserTypeValidator {

    private final UserMapper userMapper;

    public boolean isAdmin(Integer userId) {
        if (userId == null) {
            throw new ApiException(ExceptionEnum.USER_NOT_LOGIN);
        }

        if (!userMapper.existsById(userId)) {
            throw new ApiException(ExceptionEnum.USER_NOT_EXIST);
        }

        Integer userType = userMapper.selectUserTypeById(userId);
        return userType != null && userType == 2;
    }

    public void validateAdmin(Integer userId) {
        if (!isAdmin(userId)) {
            throw new ApiException(ExceptionEnum.ACCESS_DENIED);
        }
    }
}