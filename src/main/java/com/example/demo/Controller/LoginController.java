package com.example.demo.Controller;

import com.example.demo.Domain.ResponseResult;
import com.example.demo.Dto.LoginUserDto;
import com.example.demo.Service.LoginService;
import com.example.demo.Util.BeanCopyUtils;
import com.example.demo.generator.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginUserDto loginUserDto){
        User user = BeanCopyUtils.copyBean(loginUserDto,User.class);
        return loginService.login(user);
    }
}
