package com.software.personalmanagement.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AttendanceVO {
    private Integer id;
    private String startDate;
    private String name;
    private String startTime;       //上班打卡
    private String endTime;         //下班打卡
    private Double workTime;        //工作时长
    private String status;
}
