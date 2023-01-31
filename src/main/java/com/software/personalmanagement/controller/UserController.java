package com.software.personalmanagement.controller;

import com.software.personalmanagement.entity.User;
import com.software.personalmanagement.service.UserService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public DataVO login(String username, String password){
        User user= userService.login(username, password);
        if(user!=null){
//            user.setPassword(null);
//            session.setAttribute("employeeInfo",user);
            return DataVO.success();
        }
        return DataVO.fail("用户名或密码错误");
    }
/*    @PostMapping("/login")
    public DataVO login(User user, HttpSession session){
        User user1 = userService.login(user);
        if(user1!=null){
            user1.setPassword(null);
            session.setAttribute("employeeInfo", user1);
            return DataVO.success();
        }
        return DataVO.fail("用户名或密码错误");
    }*/
}
