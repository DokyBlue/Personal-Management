package com.software.personalmanagement.service;

import com.software.personalmanagement.vo.AttendanceVO;
import com.software.personalmanagement.vo.DataVO;

public interface AttendanceService {
    public DataVO<AttendanceVO> startWork(AttendanceVO attendanceVO);

    public DataVO<AttendanceVO> endWork(AttendanceVO attendanceVO);
}
