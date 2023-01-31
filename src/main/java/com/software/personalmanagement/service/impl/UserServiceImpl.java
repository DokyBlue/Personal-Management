package com.software.personalmanagement.service.impl;

import com.software.personalmanagement.entity.User;
import com.software.personalmanagement.mapper.UserMapper;
import com.software.personalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUser(username, password);
    }
/*    @Override
    public User login(User user){
        return userMapper.getUser(user);
    }*/
}
