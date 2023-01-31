package com.software.personalmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//设置默认界面
@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(){
        return "login";
    }
}
