package com.software.personalmanagement.controller;

import com.software.personalmanagement.entity.User;
import com.software.personalmanagement.service.UserService;
import com.software.personalmanagement.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public DataVO login(String username, String password, HttpServletResponse response){
        User user= userService.login(username, password);
        if(user!=null){
            user.setPassword(null);
            /*HttpSession session = request.getSession(true);
            session.setAttribute("employeeInfo",user);*/

            //保存当前用户的登录信息
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            usernameCookie.setMaxAge(60*60*24);//设置cookie持续一天，便于打卡上下班
            passwordCookie.setMaxAge(60*60*24);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);

            return DataVO.success();
        }
        return DataVO.fail("用户名或密码错误");
    }
}
