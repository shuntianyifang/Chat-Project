package com.github.shuntianyifang.chatproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank
    @Size(max = 10)
    private String username;

    @NotBlank
    @Size(max = 10)
    private String name;

    @NotBlank
    @Size(max = 16,min = 8)
    private String password;

    @NotNull
    private Integer user_type;
}
