package com.github.shuntianyifang.chatproject.controller;

import com.github.shuntianyifang.chatproject.dto.request.LoginRequest;
import com.github.shuntianyifang.chatproject.dto.request.RegisterRequest;
import com.github.shuntianyifang.chatproject.dto.response.LoginResponse;
import com.github.shuntianyifang.chatproject.dto.response.RegisterResponse;
import com.github.shuntianyifang.chatproject.entity.User;
import com.github.shuntianyifang.chatproject.result.AjaxResult;
import com.github.shuntianyifang.chatproject.service.LoginService;
import com.github.shuntianyifang.chatproject.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Resource
    private LoginService loginService;
    @Resource
    private RegisterService registerService;

    @PostMapping("/login")
    public AjaxResult<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        User user = loginService.login(request.getUsername(), request.getPassword());
        LoginResponse response = new LoginResponse(user.getUserId(), user.getUserType());
        return AjaxResult.success(response);
    }

    @PostMapping("/reg")
    public AjaxResult<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        User user = registerService.register(request.getUsername(), request.getName(), request.getPassword(), request.getUser_type());
        RegisterResponse response = new RegisterResponse(user.getUserId(), user.getUserType());
        return AjaxResult.success(response);
    }
}