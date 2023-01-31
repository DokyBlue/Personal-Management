package com.software.personalmanagement.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
    }
}