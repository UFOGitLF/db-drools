package com.fly.repository;

import com.fly.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description : 规则CRUD
 * @Author : liu.fly 2018/4/20
 */
@Repository
public interface RuleRepository extends JpaRepository<Rule,Integer>{
}
