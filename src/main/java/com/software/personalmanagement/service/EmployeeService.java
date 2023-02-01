package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.EmployeeVO;

public interface EmployeeService {

    DataVO<EmployeeVO> list(Integer page, Integer limit);

    //新增
    int insert(Employee employee);

    //删除
    Integer delete(int id);

    //查询
    DataVO<EmployeeVO> find(String name);

    int update(Employee employee);
}
