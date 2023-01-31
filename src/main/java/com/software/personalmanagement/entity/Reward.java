package com.software.personalmanagement.entity;

import lombok.Data;

@Data
public class Reward {
    private Integer id;
    private String department;
    private String name;
    private String theme;
    private Integer status;
    private Double price;
    private String message;

    public boolean getStatus() {
        if(status==1) return true;
        else return false;
    }
}
