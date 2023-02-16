package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AttendanceServiceTest {

    @Autowired
    private AttendanceService attendanceService;

    @Test
    void attendanceList() {
        DataVO dataVO = attendanceService.attendanceList(1,10);
        int i = 1;
    }

    @Test
    void findByUsername(){
        Employee employee=new Employee();
        employee = attendanceService.findByUsername("022020114");
        int i=1;
    }
}