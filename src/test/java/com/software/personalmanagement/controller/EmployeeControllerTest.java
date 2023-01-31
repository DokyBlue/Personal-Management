package com.software.personalmanagement.controller;

import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;

class EmployeeControllerTest {

    private EmployeeController employeeController;
    private EmployeeService employeeService;

    @Test
    void list() {
        employeeController = new EmployeeController();
        employeeController.list(1,10);
        int i = 1;
    }

    @Test
    void redirect() {
    }

    @Test
    void insert(){
        Employee employee = new Employee();
        employeeController.insert(employee);
        int i = 1;
    }
}