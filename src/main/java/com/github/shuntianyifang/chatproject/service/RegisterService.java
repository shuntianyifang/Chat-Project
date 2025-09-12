package com.github.shuntianyifang.chatproject.service;

import com.github.shuntianyifang.chatproject.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface RegisterService {

    User register(@NotBlank @Size(max = 10) String username, @NotBlank @Size(max = 10) String name, @NotBlank @Size(max = 20) String password, @NotNull Integer userType);
}
