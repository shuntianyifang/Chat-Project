package com.github.shuntianyifang.chatproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private Integer user_id;
    private Integer user_type;
}
