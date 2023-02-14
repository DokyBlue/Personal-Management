package com.software.personalmanagement.vo;

import lombok.Data;

@Data
public class SalaryVO {
    private Integer id;
    private String department;
    private String name;
    private String creatTime;
    private Double baseSalary;
    private Double addSalary;
    private Double lastSalary;
}
