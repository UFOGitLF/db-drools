package com.fly.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description : 规则
 * @Author : liu.fly 2018/4/20
 */
@Data
@Table(name = "drools_rule")
@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private String rule;
    private String name;
    @Column(name = "create_time",updatable = false)
    @CreationTimestamp
    private Date createTime;
    @Column(name = "update_time")
    @UpdateTimestamp
    private Date updateTime;
    private Integer visible;

}
