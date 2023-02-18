package com.example.demo.Service;

import com.example.demo.Domain.ResponseResult;
import com.example.demo.generator.domain.User;

public interface LoginService {
    ResponseResult login(User user);
}
