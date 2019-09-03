package com.java.study.javastudy.controller;


import com.java.study.javastudy.annotations.MyMethodLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@RequestMapping(value = {"javaJar","javaClass"}, method = {RequestMethod.POST})
public class JavaJarRelyOnBean {
    /**
     *
     * @param param
     * @param integer
     * @return   返回值的介绍
     */
    @MyMethodLog
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String test1(@RequestParam @Autowired String param,Integer integer) {
        System.out.println("java Jar test1");
        return "test1";
    }

    @RequestMapping("test2")
    public String[] test2() {
        System.out.println("java Jar test2");
        return null;
    }

    @RequestMapping("test3")
    public ResultVo<List<MyObject>> test3() {
        System.out.println("java Jar test2");
        return ResultVo.getFailed("",null);
    }
}
