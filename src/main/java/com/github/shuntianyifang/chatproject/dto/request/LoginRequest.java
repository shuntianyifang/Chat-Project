package com.github.shuntianyifang.chatproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    private String password;
}
