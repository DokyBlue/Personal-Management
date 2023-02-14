package com.software.personalmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.personalmanagement.entity.Reward;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RewardMapper extends BaseMapper<Reward> {
    @Insert("insert into reward(department, name, theme, status, price, message)" +
            "values (#{department}, #{name}, #{theme}, #{status}, #{price}, #{message})")
    public int insertReward(Reward reward);

    @Delete("delete from reward where id = #{id}")
    public int delete(int id);

    @Select("select * from reward where name = #{name}")
    public Reward findReward(String name);

    @Update("update reward set department=#{department}, name=#{name}, theme=#{theme}, status=#{status}, price=#{price}, message=#{message} where id=#{id}")
    public int updateReward(Reward reward);

}
