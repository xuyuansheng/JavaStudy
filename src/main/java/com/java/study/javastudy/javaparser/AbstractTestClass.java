package com.java.study.javastudy.javaparser;

/**
 * @program: java-study
 * @description: 测试抽象类
 * @author: Mr.Xu
 * @create: 2019/7/30 22:15
 */
public abstract class AbstractTestClass implements TestClassInterface {

    @Override
    public Object testMethod() {
        return "null 值";
    }
}
