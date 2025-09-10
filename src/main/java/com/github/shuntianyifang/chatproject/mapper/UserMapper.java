package com.github.shuntianyifang.chatproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.shuntianyifang.chatproject.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT user_type FROM user WHERE user_id = #{userId}")
    Integer selectUserTypeById(Integer userId);

    @Select("SELECT * FROM WHERE user_id = #{userId}")
    User selectUserById(Integer userId);

    @Select("SELECT  COUNT(*) FROM user WHERE user_id = #{userID}")
    boolean existsById(Integer userID);

}

