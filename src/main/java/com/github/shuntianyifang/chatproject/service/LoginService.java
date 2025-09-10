package com.github.shuntianyifang.chatproject.service;

import com.github.shuntianyifang.chatproject.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface LoginService {
    Integer login(String username, String password, Integer user_type, Integer user_id);

    User login(@NotBlank @Size(max = 20) String username, @NotBlank String password);
}
