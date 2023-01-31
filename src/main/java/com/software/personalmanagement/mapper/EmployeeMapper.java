package com.software.personalmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.service.EmployeeService;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    @Insert("insert into employee(name, phone, email, department_id, status, level_id, username, age, sex, permission)" +
            "values (#{name}, #{phone}, #{email}, #{departmentId}, #{status}, #{levelId}, #{username}, #{age}, #{sex}, #{permission})")
    public int insert(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public int delete(int id);

    //根据姓名查找
    @Select("select * from employee where name = #{name}")
    public Employee find(String name);

    @Update("update employee set name=#{name},phone=#{phone},email=#{email},department_id=#{departmentId},level_id=#{levelId},username=#{username},age=#{age},sex=#{sex} where id = #{id}")
    public int update(Employee employee);
}
