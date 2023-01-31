package com.software.personalmanagement.controller;

import com.software.personalmanagement.vo.DataVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    private UserController userController;

    @Test
    void login() {
        DataVO dataVO1 = userController.login("test1", "123456");

        int i=1;
    }
}