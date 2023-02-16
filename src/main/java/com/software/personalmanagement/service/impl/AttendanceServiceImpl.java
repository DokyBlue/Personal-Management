package com.software.personalmanagement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.software.personalmanagement.entity.Attendance;
import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.mapper.AttendanceMapper;
import com.software.personalmanagement.mapper.EmployeeMapper;
import com.software.personalmanagement.service.AttendanceService;
import com.software.personalmanagement.vo.AttendanceVO;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public DataVO<AttendanceVO> attendanceList(Integer page, Integer limit) {
        DataVO dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Attendance> attendanceIPage = new Page<>(page, limit);
        IPage<Attendance> result = attendanceMapper.selectPage(attendanceIPage,null);

        dataVO.setCount((int) result.getTotal());
        List<Attendance> attendanceList = result.getRecords();
        List<AttendanceVO> attendanceVOList = new ArrayList<>();

        for (Attendance attendance : attendanceList){
            AttendanceVO attendanceVO = new AttendanceVO();

            if(attendance.getStatus()==1)attendanceVO.setStatus("在职");
            else attendanceVO.setStatus("离职");

            BeanUtils.copyProperties(attendance,attendanceVO);
            attendanceVOList.add(attendanceVO);
        }
        dataVO.setData(attendanceVOList);
        return dataVO;
    }

    //新增
    @Override
    public int startWork(Attendance attendance) {
        return attendanceMapper.startWork(attendance);
    }

    //更新
    @Override
    public int endWork(Attendance attendance) {
        return attendanceMapper.endWork(attendance);
    }

    @Override
    public Integer delete(int id) {
        return attendanceMapper.delete(id);
    }

    @Override
    public DataVO<AttendanceVO> findAttendance(String name) {
        DataVO dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");

        Attendance attendance = attendanceMapper.findAttendance(name);
        AttendanceVO attendanceVO = new AttendanceVO();

        BeanUtils.copyProperties(attendance,attendanceVO);
        List<AttendanceVO> attendanceVOList = new ArrayList<>();

        if (attendance.getStatus()==1)attendanceVO.setStatus("在职");
        else attendanceVO.setStatus("离职");

        attendanceVOList.add(attendanceVO);
        dataVO.setData(attendanceVOList);
        return dataVO;
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeMapper.findByUsername(username);
    }
}
