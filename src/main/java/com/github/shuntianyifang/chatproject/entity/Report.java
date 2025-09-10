package com.github.shuntianyifang.chatproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value ="report")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
    @TableId(type = IdType.AUTO)
    @JsonProperty("report_id")
    private Integer reportId;

    private String reason;

    @JsonProperty("post_id")
    private Integer postId;

    @JsonProperty("user_id")
    private Integer userId;

    private String username;

    private String content;

    private Integer status;
}