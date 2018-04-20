package com.fly.service;

import com.fly.entity.Rule;
import com.fly.entity.XiaoMing;
import com.fly.exception.BusinessException;
import com.fly.exception.ExceptionType;
import com.fly.repository.RuleRepository;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Description : 规则
 * @Author : liu.fly 2018/4/20
 */
@Service
public class RuleService {
    @Resource
    private RuleRepository repository;

    /**
     * 动态加载已经部署的rule
     * @param id
     * @param xm
     * @return
     */
    public XiaoMing getRulesWrite(Integer id,XiaoMing xm){
        String rules;
        Rule rule = repository.getOne(id);
        if (null != rule && !StringUtils.isEmpty(rule.getRule())){
            rules = rule.getRule();
        }else{
            throw new BusinessException(ExceptionType.RULE_IS_NULL);
        }
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write("src/main/resources/rules/rules.drl",rules.getBytes());
        KieBuilder kb = ks.newKieBuilder(kfs).buildAll();
        Results rs = kb.getResults();
        if (rs.hasMessages(Message.Level.ERROR)){
            System.out.println(rs.getMessages());
            throw new IllegalStateException("### ERROR ###");
        }
        KieContainer kc = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
        KieBase kieBase = kc.getKieBase();
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(xm);
        kieSession.fireAllRules();
        return xm;


    }

}
