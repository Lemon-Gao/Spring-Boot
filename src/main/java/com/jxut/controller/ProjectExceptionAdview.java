package com.jxut.controller;


import com.jxut.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdview {

    @ExceptionHandler
    public Result doException(Exception ex){
        return new Result("服务器异常，程序猿小哥正在抢修");
    }
}
