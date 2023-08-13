package com.atguigu.ggkt.config.exception;

import com.atguigu.ggkt.config.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

//    全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error (Exception e){
        System.out.println("全局异常...");
        e.printStackTrace();
        return Result.fail().message("执行了全局异常");
    }

//    特定异常处理
@ExceptionHandler(ArithmeticException.class)
@ResponseBody
public Result error (ArithmeticException e){
    System.out.println("特定异常...");
    e.printStackTrace();
    return Result.fail().message("执行了ArithmeticException异常");
}

    //    抛出自定义异常
    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error (GgktException e){
        System.out.println("自定义异常...");
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }





}
