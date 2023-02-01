package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    void findData() {
        DataVO dataVO1 = service.list(1,10);        //正常一页显示10条数据
        DataVO dataVO2 = service.list(0,1);         //第0页的显示
        DataVO dataVO3 = service.list(2,100);       //第一页已经显示完所有数据
        DataVO dataVO4 = service.list(1,0);         //一页显示0条数据的情况
        int i = 1;
    }

    @Test
    void insert(){
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setName("zj");
        employee.setEmail("123");
        employee.setPhone(123456.0);
        employee.setPermission(1);
        employee.setDepartmentId(1);
        employee.setLevelId(1);
        employee.setSex(1);
        employee.setStatus(1);
        employee.setUsername("123");
        service.insert(employee);
        int i = 0;
    }

    @Test
    void delete(){
        service.delete(1);
        int i = 1;
    }

    @Test
    void find(){
        //Employee employee = new Employee();
        //employee = service.find("test1");
        DataVO dataVO = service.find("1234");
        DataVO dataVO1 = service.find("1");
        DataVO dataVO2 = service.find("张帆");
        int i = 1;
    }

    @Test
    void update(){
        Employee employee=new Employee();
        employee.setId(1);
        employee.setAge(20);
        employee.setName("test1");
        employee.setEmail("2047412143@qq.com");
        employee.setPhone(1234567890.0);
        employee.setPermission(1);
        employee.setDepartmentId(1);
        employee.setLevelId(1);
        employee.setSex(1);
        employee.setStatus(1);
        employee.setUsername("test1");
        service.update(employee);
        int i=1;
    }
}