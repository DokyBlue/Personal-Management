package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Salary;
import com.software.personalmanagement.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalaryServiceTest {

    @Autowired
    private SalaryService salaryService;

    @Test
    void salaryList() {
        DataVO dataVO1 = salaryService.SalaryList(1,10);
        int i = 1;
    }

    @Test
    void insertSalary() {
        Salary salary = new Salary();
        salary.setAddSalary(236.0);
        salary.setBaseSalary(10020.0);
//        salary.setLastSalary();
    }

    @Test
    void delete() {
    }

    @Test
    void findSalary() {
    }

    @Test
    void updateSalary() {
    }
}