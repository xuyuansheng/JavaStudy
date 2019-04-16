package com.java.study.javastudy.controller;


import com.java.study.javastudy.annotations.MyMethodLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("javaJar.html")
public class JavaJarRelyOnBean {

    @MyMethodLog
    @RequestMapping("test1")
    public String test1() {
        System.out.println("java Jar test1");
        return "test1";
    }

    @RequestMapping("test2")
    public String test2() {
        System.out.println("java Jar test2");
        return "test2";
    }
}
