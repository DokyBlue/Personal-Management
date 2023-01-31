package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.EmployeeVO;

public interface EmployeeService {

    DataVO<EmployeeVO> findData(Integer page, Integer limit);

    //新增
    int insert(Employee employee);

    //删除
    Integer delete(int id);

    //查询
    Employee find(String name);

    int update(Employee employee);
}
