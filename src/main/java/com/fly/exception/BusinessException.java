package com.fly.exception;

import lombok.Getter;

/**
 * @Description : 系统异常
 * @Author : liu.fly 2018/4/20
 */
@Getter
public class BusinessException extends RuntimeException{
    private int code;
    private String message;

    public BusinessException(ExceptionType exceptionType){
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMsg();
    }
    @Override
    public String getMessage(){
        return message;
    }

}
