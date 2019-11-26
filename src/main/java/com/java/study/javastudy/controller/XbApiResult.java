package com.java.study.javastudy.controller;

import lombok.Data;

/**
 * @program: java-study
 * @description: java类解析
 * @author: Mr.Xu
 * @create: 2019/9/1 12:59
 */
@Data
public class XbApiResult {
    /**
     * 姓名
     *
     * @defaultValue name的默认值
     */
    private String name = "name ";
    /**
     * 年龄
     *
     * @defaultValue age  的默认值
     */
    private Integer age;
    /**
     * 描述
     */
    private String desc;

}
