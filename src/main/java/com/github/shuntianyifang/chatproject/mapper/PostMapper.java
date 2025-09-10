package com.github.shuntianyifang.chatproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.shuntianyifang.chatproject.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface PostMapper extends BaseMapper<Post> {
    @Update("UPDATE post SET view_count = view_count + 1 WHERE id = #{id}")
    void incrementViewCount(@Param("id") Integer id);
}




