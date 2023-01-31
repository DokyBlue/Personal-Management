package com.software.personalmanagement.service;

import com.software.personalmanagement.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User login(String username, String password);
//    public User login(User user);
}
