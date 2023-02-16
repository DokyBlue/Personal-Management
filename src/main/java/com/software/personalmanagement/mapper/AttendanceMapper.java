package com.software.personalmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.personalmanagement.entity.Attendance;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {
    @Insert("insert into attendance(start_date, name, start_time, status)"+
            "values (#{startDate}, #{name}, #{startTime}, #{status})")
    int startWork(Attendance attendance);

    @Delete("delete from attendance where id=#{id}")
    int delete(int id);

    @Select("select * from attendance where name=#{name}")
    Attendance findAttendance(String name);

    @Update("update attendance set end_time=#{endTime}, work_time=#{workTime} where start_time=#{startTime}")
    int endWork(Attendance attendance);

}
