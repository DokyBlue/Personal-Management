package com.software.personalmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.personalmanagement.entity.Salary;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SalaryMapper extends BaseMapper<Salary> {
    @Insert("insert into salary(department, name, creat_time, base_salary, add_salary, last_salary)" +
            "values (#{department}, #{name}, #{creatTime}, #{baseSalary}, #{addSalary}, #{lastSalary})")
    public int insertSalary(Salary salary);

    @Delete("delete from salary where id = #{id}")
    public int delete(int id);

    @Select("select * from salary where name = #{name}")
    public Salary findSalary(String name);

    @Update("update salary set department=#{department}, name=#{name}, base_salary=#{baseSalary}, add_salary=#{addSalary}, last_salary=#{lastSalary} where id=#{id}")
    public  int updateSalary(Salary salary);
}
