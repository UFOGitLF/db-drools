package com.fly.reponse;

import java.util.HashMap;

/**
 * @Description :
 * @Author : liu.fly 2018/4/20
 */
public class Rr extends HashMap<String,Object>{

    public Rr(){
        put("code",200);
        put("msg","success");
    }
    public static Rr ok(Object o){
        Rr rr = new Rr();
        rr.put("data",o);
        return rr;
    }
}
