package com.fly.entity;

import lombok.Data;

/**
 * @Description : 小明
 * @Author : liu.fly 2018/4/20
 */
@Data
public class XiaoMing {
    /**
     * 总共的钱
     */
    private int money;
    /**
     * 空瓶子数量
     */
    private int bottle;

    /**
     * 已经喝掉的汽水数量
     */
    private int drink;
}
