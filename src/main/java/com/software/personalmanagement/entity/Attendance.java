package com.software.personalmanagement.entity;

import lombok.Data;

//打卡类

@Data
public class Attendance {
    private Integer id;
    private String startDate;
    private String name;
    private String startTime;       //上班打卡
    private String endTime;         //下班打卡
    private Double workTime;        //工作时长
    private Integer status;
}
