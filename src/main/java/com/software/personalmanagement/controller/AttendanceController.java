package com.software.personalmanagement.controller;

import com.software.personalmanagement.entity.Attendance;
import com.software.personalmanagement.entity.Employee;
import com.software.personalmanagement.service.AttendanceService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/attendanceList")
    @ResponseBody
    public DataVO attendanceList(Integer page, Integer limit){
        return attendanceService.attendanceList(page,limit);
    }

    //新增打卡
    @PostMapping("/startWork")
    @ResponseBody
    public void startWork(HttpServletRequest request, HttpServletResponse response){
        String username = null;

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("username"))
                username = cookie.getValue();
        }

        Employee employee = attendanceService.findByUsername(username);

        System.out.println(username);

        Attendance attendance = new Attendance();
        attendance.setStatus(employee.getStatus());
        attendance.setName(employee.getName());


        SimpleDateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String startDate = formatDay.format(date);

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        String time = formatTime.format(date);
        Cookie timeCookie = new Cookie("startTime",time);
        Cookie nameCookie = new Cookie("name", employee.getName());
        timeCookie.setMaxAge(60*60*24);
        nameCookie.setMaxAge(60*60*24);
        response.addCookie(timeCookie);
        response.addCookie(nameCookie);

        attendance.setStartTime(time);
        attendance.setStartDate(startDate);

        attendanceService.startWork(attendance);
    }

    @PostMapping("endWork")
    @ResponseBody
    public void endWork(HttpServletRequest request){
        Attendance attendance = new Attendance();

        String startDate = null;
        String startTime = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("startTime"))
                startTime = cookie.getValue();
            if(cookie.getName().equals("startDate"))
                startDate=cookie.getValue();
        }
        attendance.setStartTime(startTime);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date(System.currentTimeMillis());
        String endTime = format.format(date);
        String day = dateFormat.format(date);

        try {
            Date start = format.parse(startTime);
            Date end = format.parse(endTime);
            long startTimeLong = start.getTime();
            long endTimeLong = end.getTime();
            Integer workTime = (int) (endTimeLong-startTimeLong)/(60*60*1000);
            if (day!=startDate) workTime+=24;
            attendance.setWorkTime(workTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        attendance.setEndTime(endTime);

        attendanceService.endWork(attendance);
    }

    @DeleteMapping("/deleteAttendance/{id}")
    public void delete(@PathVariable Integer id){
        attendanceService.delete(id);
    }

    @RequestMapping("/findAttendance/{name}")
    @ResponseBody
    public DataVO find(@PathVariable String name){
        return attendanceService.findAttendance(name);
    }

    @GetMapping("/attendance/{attendance}")
    public String redrict(@PathVariable("attendance") String url){
        return url;
    }

}
