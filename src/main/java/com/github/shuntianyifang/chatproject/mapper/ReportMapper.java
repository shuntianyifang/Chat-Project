package com.github.shuntianyifang.chatproject.mapper;

import com.github.shuntianyifang.chatproject.entity.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface ReportMapper extends BaseMapper<Report> {

    @Select("SELECT r.*, p.content as post_content, p.user_id as post_author_id, p.created_at as post_created_at " +
            "FROM report r LEFT JOIN post p ON r.post_id = p.id " +
            "WHERE r.user_id = #{userId}")
    List<Map<String, Object>> selectReportsWithPostsByUserId(Integer userId);
}




