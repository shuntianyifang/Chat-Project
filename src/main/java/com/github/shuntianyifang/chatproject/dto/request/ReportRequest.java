package com.github.shuntianyifang.chatproject.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {
    @NotNull
    @JsonProperty("user_id")
    private Integer userId;
    @NotNull
    @JsonProperty("post_id")
    private Integer postId;
    @NotBlank
    private String reason;
}
