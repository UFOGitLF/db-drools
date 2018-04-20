package com.fly.controller;

import com.fly.entity.Rule;
import com.fly.entity.XiaoMing;
import com.fly.reponse.Rr;
import com.fly.repository.RuleRepository;
import com.fly.service.RuleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description : 规则
 * @Author : liu.fly 2018/4/20
 */
@RestController
@RequestMapping("rules")
public class RuleController {
    @Resource
    private RuleService ruleService;
    @Resource
    private RuleRepository ruleRepository;

    /**
     * 添加规则
     * @param rule
     * @param name
     * @return
     */
    @RequestMapping("add")
    public Rr ruleAdd(@RequestParam String rule,
                      @RequestParam String name) {
        Rule r = new Rule();
        r.setName(name);
        r.setRule(rule);
        //启用
        r.setVisible(1);
        ruleRepository.save(r);
        return Rr.ok(r);
    }

    /**
     * 执行结果
     * @param id
     * @param xm
     * @return
     */
    @PostMapping("result")
    public Rr getResult(@RequestParam("id") Integer id,
                        XiaoMing xm) {
        return Rr.ok(ruleService.getRulesWrite(id, xm));
    }

}
