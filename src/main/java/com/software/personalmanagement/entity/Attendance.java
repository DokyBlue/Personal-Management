package com.software.personalmanagement.entity;

import lombok.Data;

@Data
public class Attendance {
    private Integer id;
    private String startDate;
    private String name;
    private String startTime;       //上班打卡
    private String endTime;         //下班打卡
    private Integer workTime;        //工作时长
    private Integer status;
}
