package com.github.shuntianyifang.chatproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.shuntianyifang.chatproject.constant.ExceptionEnum;
import com.github.shuntianyifang.chatproject.entity.User;
import com.github.shuntianyifang.chatproject.exception.ApiException;
import com.github.shuntianyifang.chatproject.mapper.UserMapper;
import com.github.shuntianyifang.chatproject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUsername, username);

        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            throw new ApiException(ExceptionEnum.WRONG_USERNAME_OR_PASSWORD);
        } else if (!user.getPassword().equals(password)) {
            throw new ApiException(ExceptionEnum.WRONG_USERNAME_OR_PASSWORD);
        }
        return user;
    }
}
