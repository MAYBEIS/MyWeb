package com.example.demo.Handler;

import com.example.demo.Constant.ExceptionConstant;
import com.example.demo.Domain.ResponseResult;
import com.example.demo.Domain.SystemException;
import com.example.demo.Enum.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e){
        log.error(ExceptionConstant.ERROR_MSG);
        log.error(String.valueOf(e));
        //打印异常信息
//        log.error("出现了异常！ {}",e);
        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(e.getCode(),e.getMsg());
    }


    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){
        log.error(ExceptionConstant.ERROR_MSG);
        //打印异常信息
        log.error(String.valueOf(e));
        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),e.getMessage());
    }
}
