package com.software.personalmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@MapperScan("com.software.personalmanagement.mapper")
public class PersonalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalManagementApplication.class, args);
    }



}
