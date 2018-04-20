package com.fly.exception;

import lombok.Getter;

/**
 * @Description : 异常类型枚举
 * @Author : liu.fly 2018/4/20
 */
@Getter
public enum ExceptionType {

    SYSTEM_ERROR(500,"系统错误"),SUCCESS(200,"成功"),RULE_IS_NULL(600,"系统错误"),RULE_IS_ERROR(700,"规则语句错误");

    private int code;
    private String msg;

    ExceptionType(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
