package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void login() {
        User user1 = userService.login("test1","123456");
        User user2 = userService.login("test2","123456");
        User user3 = userService.login("test1","1");
        User user4 = userService.login("test0","123456");
        int i=0;
    }
}