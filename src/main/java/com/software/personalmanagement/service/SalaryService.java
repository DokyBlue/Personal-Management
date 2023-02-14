package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Salary;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.SalaryVO;

public interface SalaryService {
    DataVO<SalaryVO> SalaryList(Integer page, Integer limit);

    //新增
    int insertSalary(Salary salary);

    //删除
    Integer delete(int id);

    //查询
    DataVO<SalaryVO> findSalary(String name);

    //更新
    int updateSalary(Salary salary);
}
