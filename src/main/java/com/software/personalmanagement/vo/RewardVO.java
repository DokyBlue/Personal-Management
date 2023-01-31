package com.software.personalmanagement.vo;

import lombok.Data;

@Data
public class RewardVO {
    private Integer id;
    private String department;
    private String name;
    private String theme;
    private String status;
    private Double price;
    private String message;
}
