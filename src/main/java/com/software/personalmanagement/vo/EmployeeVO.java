package com.software.personalmanagement.vo;

import lombok.Data;

@Data
public class EmployeeVO {
    private Integer id;
    private String name;
    private Double phone;
    private String email;
    private String department;
    private String level;
    private String username;
    private Integer age;
    private String sex;
    private String status;
    private Integer permission;
}
