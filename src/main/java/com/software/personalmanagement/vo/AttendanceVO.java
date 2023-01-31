package com.software.personalmanagement.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AttendanceVO {
    private Integer id;
    private Date date;
    private String name;
    private Date start;     //上班打卡
    private Date end;       //下班打卡
    private Double workTime;//工作时长
}
