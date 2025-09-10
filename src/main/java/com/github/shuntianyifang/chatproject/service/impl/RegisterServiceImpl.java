package com.github.shuntianyifang.chatproject.service.impl;

import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.service.RegisterService;
import com.github.shuntianyifang.chatproject.mapper.UserMapper;
import com.github.shuntianyifang.chatproject.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserMapper userMapper;

    @Override
    public Integer register(String username, String name, String password, Integer user_type, Integer user_id) {
        return 0;
    }

    @Override
    public User register(String username, String name, String password, Integer user_type) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);

        if (userMapper.selectOne(queryWrapper) != null) {
            throw new ApiException(ExceptionEnum.USER_ALREADY_EXISTS);
        } else if (password.length() > 16) {
            throw new ApiException(ExceptionEnum.WRONG_PASSWORD_SIZE);
        }  else if (password.length() < 8) {
            throw new ApiException(ExceptionEnum.WRONG_PASSWORD_SIZE);
        }

        User newUser = User.builder()
                .username(username)
                .name(name)
                .password(password)
                .userType(user_type)
                .build();

        userMapper.insert(newUser);
        return newUser;
    }
}