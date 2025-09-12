package com.github.shuntianyifang.chatproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BaseListResponse<T> {
    private List<T> post_list;
}
