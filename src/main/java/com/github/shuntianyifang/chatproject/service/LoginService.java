package com.github.shuntianyifang.chatproject.service;

import com.github.shuntianyifang.chatproject.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface LoginService {
    User login(@NotBlank @Size(max = 20) String username, @NotBlank String password);
}
