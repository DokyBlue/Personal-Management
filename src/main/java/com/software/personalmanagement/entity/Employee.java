package com.software.personalmanagement.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Double phone;
    private String email;
    private Integer departmentId;
    private Integer levelId;
    private String username;
    private Integer age;
    private Integer sex;
    private Integer status;
    private Integer permission;

    public boolean getSex(){
        if(status==1)return false;
        else return true;
    }
    public Integer getPermission(){
        return permission;
    }
}
