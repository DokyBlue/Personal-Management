package com.software.personalmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.personalmanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM employee WHERE username =#{username} AND password = #{password}")
    public User getUser(@Param("username")String username, @Param("password")String password);
/*    public User getUser(User user);*/
}
