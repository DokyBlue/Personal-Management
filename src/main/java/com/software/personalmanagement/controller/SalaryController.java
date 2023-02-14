package com.software.personalmanagement.controller;

import com.software.personalmanagement.entity.Salary;
import com.software.personalmanagement.service.SalaryService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/salarylist")
    @ResponseBody
    public DataVO salaryList(Integer page, Integer limit){
        return salaryService.SalaryList(page,limit);
    }

    //新增
    @PostMapping("/addSalary")
    @ResponseBody
    public void insert(@RequestBody HashMap<String,String> map) throws ParseException {
        Integer departmentId = Integer.valueOf(map.get("department"));
        String department;
        String name = map.get("name");
        Double base = Double.valueOf(map.get("baseSalary"));
        Double add = Double.valueOf(map.get("addSalary"));
        Double lastSalary = base+add;

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String creatTime=formatter.format(date);

        switch (departmentId){
            case 1: department="管理部";break;
            case 2: department="财务部";break;
            case 3: department="测试部";break;
            case 4: department="人事部";break;
            case 5: department="行政部";break;
            case 6: department="宣传部";break;
            default: department=null;
        }

        Salary salary = new Salary();
        salary.setLastSalary(lastSalary);
        salary.setBaseSalary(base);
        salary.setDepartment(department);
        salary.setAddSalary(add);
        salary.setName(name);
        salary.setCreatTime(creatTime);
        salaryService.insertSalary(salary);
    }

    //删除薪资信息
    @DeleteMapping("/deleteSalary/{id}")
    public void delete(@PathVariable Integer id){
        salaryService.delete(id);
    }

    //根据姓名查找
    @RequestMapping("/findSalary/{name}")
    @ResponseBody
    public DataVO find(@PathVariable String name){
        return salaryService.findSalary(name);
    }

    //修改薪资信息
    @PostMapping("/updateSalary")
    @ResponseBody
    public void updateSalary(@RequestBody HashMap<String, String> map){
        String department = map.get("department");
        String name = map.get("name");
        Double base = Double.valueOf(map.get("baseSalary"));
        Double add = Double.valueOf(map.get("addSalary"));
        Integer id = Integer.valueOf(map.get("id"));
        Double lastSalary = base+add;

        Salary salary = new Salary();
        salary.setId(id);
        salary.setLastSalary(lastSalary);
        salary.setBaseSalary(base);
        salary.setDepartment(department);
        salary.setAddSalary(add);
        salary.setName(name);
        salaryService.updateSalary(salary);
    }

    @GetMapping("/salary/{salary}")
    public String redirct(@PathVariable("salary") String url){
        return url;
    }

}
