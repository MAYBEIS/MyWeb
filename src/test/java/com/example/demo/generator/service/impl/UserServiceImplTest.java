package com.example.demo.generator.service.impl;

import com.example.demo.generator.domain.User;
import com.example.demo.generator.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback
class UserServiceImplTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testAddUser(){
        User user = new User();
        user.setName("May");
        userMapper.insert(user);

    }

}