package com.software.personalmanagement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software.personalmanagement.entity.Salary;

import com.software.personalmanagement.mapper.SalaryMapper;
import com.software.personalmanagement.service.SalaryService;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.SalaryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public DataVO<SalaryVO> SalaryList(Integer page, Integer limit){
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Salary> salaryIPage = new Page<>(page,limit);
        IPage<Salary> result = salaryMapper.selectPage(salaryIPage,null);

        dataVO.setCount((int) result.getTotal());
        List<Salary> salaryList = result.getRecords();
        List<SalaryVO> salaryVOList = new ArrayList<>();

        for (Salary salary : salaryList){
            SalaryVO salaryVO = new SalaryVO();
            BeanUtils.copyProperties(salary, salaryVO);

            salaryVOList.add(salaryVO);
        }
        dataVO.setData(salaryVOList);
        return dataVO;
    }

    @Override
    public int insertSalary(Salary salary) {
        salary.setLastSalary(salary.getBaseSalary()+salary.getAddSalary());
        return salaryMapper.insertSalary(salary);
    }

    @Override
    public Integer delete(int id) {
        return salaryMapper.delete(id);
    }

    @Override
    public DataVO<SalaryVO> findSalary(String name) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        Salary salary = salaryMapper.findSalary(name);
        SalaryVO salaryVO = new SalaryVO();

        BeanUtils.copyProperties(salary, salaryVO);

        List<SalaryVO> salaryVOList = new ArrayList<>();

        salaryVOList.add(salaryVO);
        dataVO.setData(salaryVOList);
        return dataVO;
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }
}
