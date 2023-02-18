package com.example.demo.Controller;

import com.example.demo.Domain.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "主页")
public class HomeController {
    @GetMapping("/home")
    @ApiOperation(value = "首页",notes = "首页备注")
    public ResponseResult getHome(){
        return ResponseResult.okResult();
    }
}
