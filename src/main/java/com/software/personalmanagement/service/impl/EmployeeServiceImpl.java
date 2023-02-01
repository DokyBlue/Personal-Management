package com.software.personalmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software.personalmanagement.entity.Department;
import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.entity.Level;
import com.software.personalmanagement.mapper.DepartmentMapper;
import com.software.personalmanagement.mapper.EmployeeMapper;
import com.software.personalmanagement.mapper.LevelMapper;
import com.software.personalmanagement.service.EmployeeService;
import com.software.personalmanagement.vo.DataVO;
import com.software.personalmanagement.vo.EmployeeVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private LevelMapper levelMapper;


    @Override
    public DataVO<EmployeeVO> list(Integer page, Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Employee> employeeIPage = new Page<>(page,limit);
        IPage<Employee> result = employeeMapper.selectPage(employeeIPage,null);

        dataVO.setCount((int) result.getTotal());
        List<Employee> employeeList = result.getRecords();
        List<EmployeeVO> employeeVOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeVO employeeVO = new EmployeeVO();
            BeanUtils.copyProperties(employee,employeeVO);

            if(employee.getStatus() == 1) employeeVO.setStatus("在职");
            else if (employee.getStatus() == 0) {
                employeeVO.setStatus("离职");
            }
            else employeeVO.setStatus(null);
            if(employee.getSex()) employeeVO.setSex("女");
            else employeeVO.setSex("男");

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",employee.getDepartmentId());
            Department department = departmentMapper.selectOne(wrapper);
            if(department!=null){
                employeeVO.setDepartment(department.getName());
            }

            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("id",employee.getLevelId());
            Level level = levelMapper.selectOne((wrapper1));
            if(level!=null) {
                employeeVO.setLevel(level.getName());
            }
            employeeVOList.add(employeeVO);
        }

        dataVO.setData(employeeVOList);

        return dataVO;
    }

    @Override
    public int insert(Employee employee){
        return employeeMapper.insert(employee);
    }

    @Override
    public Integer delete(int id){
        return employeeMapper.delete(id);
    }

    @Override
    public DataVO<EmployeeVO> find(String name){
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        Employee employee = employeeMapper.find(name);
        EmployeeVO employeeVO = new EmployeeVO();

        BeanUtils.copyProperties(employee,employeeVO);

        if(employee.getStatus() == 1) employeeVO.setStatus("在职");
        else if (employee.getStatus() == 0) {
            employeeVO.setStatus("离职");
        }
        else employeeVO.setStatus(null);
        if(employee.getSex()) employeeVO.setSex("女");
        else employeeVO.setSex("男");

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",employee.getDepartmentId());
        Department department = departmentMapper.selectOne(wrapper);
        if(department!=null){
            employeeVO.setDepartment(department.getName());
        }

        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("id",employee.getLevelId());
        Level level = levelMapper.selectOne((wrapper1));
        if(level!=null) {
            employeeVO.setLevel(level.getName());
        }

        List<EmployeeVO> employeeVOList = new ArrayList<>();

        employeeVOList.add(employeeVO);

        dataVO.setData(employeeVOList);

        return dataVO;
    }

    @Override
    public int update(Employee employee){
        return employeeMapper.update(employee);
    }
}
