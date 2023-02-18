package com.example.demo.Controller;

import com.example.demo.Domain.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseResult getUser(){
        return ResponseResult.okResult();
    }

}
