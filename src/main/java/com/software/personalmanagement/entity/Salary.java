package com.software.personalmanagement.entity;

import lombok.Data;

@Data
public class Salary {
    private Integer id;
    private String department;
    private String name;
    private String creatTime;
    private Double baseSalary;
    private Double addSalary;
    private Double lastSalary;
}
