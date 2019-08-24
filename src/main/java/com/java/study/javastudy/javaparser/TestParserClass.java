package com.java.study.javastudy.javaparser;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: java-study
 * @description: 测试javaparser的类
 * @author: Mr.Xu
 * @create: 2019/7/30 21:31
 */
@Data
@Accessors(chain = true)
public class TestParserClass extends AbstractTestClass{

    /**
     * 属性name
     */
    private String name;
    // 属性age
    private Integer age;
    /**
     * 属性gender
     */
    private Boolean gender;//性别

    /**
     * 说话的方法
     *
     * @param content 说的内容
     */
    public void speak(String content) {
        System.out.println(name + "正在说话: " + content);
    }

    /**
     * 写字的方法
     *
     * @param count 写的字的个数
     * @return 返回已经写了的字个数
     */
    public String xiezi(Integer count) {
        System.out.println("写字");
        return "已经写了 " + count + " 个字";
    }

}
