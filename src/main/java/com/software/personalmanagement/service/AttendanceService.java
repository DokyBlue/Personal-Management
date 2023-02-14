package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.Attendance;
import com.software.personalmanagement.vo.AttendanceVO;
import com.software.personalmanagement.vo.DataVO;

public interface AttendanceService {
    DataVO<AttendanceVO> AttendanceList(Integer page, Integer limit);

    //通过新增实现
    int startWork(Attendance attendance);

    //通过更新实现
    int endWork(Attendance attendance);

    //删除
    Integer delete(int id);

    //查询
    DataVO<AttendanceVO> findAttendance(String name);
}
