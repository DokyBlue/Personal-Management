package com.software.personalmanagement.entity;

import lombok.Data;

import java.util.Date;

//打卡类

@Data
public class Attendance {
    private Integer id;
    private Date date;
    private String name;
    private Date start;     //上班打卡
    private Date end;       //下班打卡
    private Double workTime;//工作时长
}
