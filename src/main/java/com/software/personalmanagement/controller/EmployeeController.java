package com.software.personalmanagement.controller;


import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.service.EmployeeService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page, Integer limit){
        return employeeService.list(page, limit);
    }

    //新增数据
    @PostMapping("/add")
    @ResponseBody
    public void insert(@RequestBody HashMap<String,String> map){
        String sex = map.get("sex");
        String name = map.get("name");
        String phone = map.get("phone");
        String email = map.get("email");
        Integer department = Integer.valueOf(map.get("department"));
        Integer level = Integer.valueOf(map.get("level"));
        String username = map.get("username");
        Integer age = Integer.valueOf(map.get("age"));

        Employee employee = new Employee();

        if(sex=="女")employee.setSex(0);
        else employee.setSex(1);


        employee.setPermission(0);
        employee.setName(name);
        employee.setPhone(Double.valueOf(phone));
        employee.setEmail(email);
        employee.setDepartmentId(department);
        employee.setLevelId(level);
        employee.setUsername(username);
        employee.setAge(age);
        employee.setStatus(1);
        employeeService.insert(employee);
    }

    //删除数据
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id, HttpServletResponse servletResponse) throws IOException {
        employeeService.delete(id);
    }

    //根据姓名查找
    @RequestMapping("/find/{name}")
    @ResponseBody
    public DataVO find(@PathVariable String name){
        return employeeService.find(name);
    }

    //修改数据
    @PostMapping("/updateEmployee")
    @ResponseBody
    public void updateEmployee(@RequestBody HashMap<String,String> map){
        Integer id = Integer.valueOf(map.get("id"));
        String sex = map.get("sex");
        String name = map.get("name");
        String phone = map.get("phone");
        String email = map.get("email");
        String department = map.get("department");
        String level = map.get("level");
        String username = map.get("username");
        Integer age = Integer.valueOf(map.get("age"));
        String status = map.get("status");

        Employee employee = new Employee();

        if(sex=="女")employee.setSex(0);
        else employee.setSex(1);

        if(status.equals("在职"))employee.setStatus(1);
        else employee.setStatus(0);

        Integer departmentId=0,levelId=0;
        switch (department){
            case "管理部": departmentId=1;break;
            case "财务部": departmentId=2;break;
            case "测试部": departmentId=3;break;
            case "人事部": departmentId=4;break;
            case "行政部": departmentId=5;break;
            case "宣传部": departmentId=6;break;
        }
        switch (level){
            case "人事主管": levelId=1;break;
            case "财务主管": levelId=2;break;
            case "管理主管": levelId=3;break;
            case "测试主管": levelId=4;break;
            case "测试员工": levelId=5;break;
            case "管理部员工": levelId=6;break;
            case "人事部员工": levelId=7;break;
            case "宣传部员工": levelId=8;break;
            case "行政部员工": levelId=9;break;
        }

        employee.setId(Integer.valueOf(id));
        employee.setPermission(0);
        employee.setName(name);
        employee.setPhone(Double.valueOf(phone));
        employee.setEmail(email);
        employee.setDepartmentId(departmentId);
        employee.setLevelId(levelId);
        employee.setUsername(username);
        employee.setAge(age);
        employeeService.update(employee);

    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

}
