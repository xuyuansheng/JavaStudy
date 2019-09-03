package com.java.study.javastudy.controller;

import lombok.Data;

/**
 * @program: java-study
 * @description: java类解析
 * @author: Mr.Xu
 * @create: 2019/9/1 12:59
 */
@Data
public class XbApiParams {
    /**
     * 索引,获取name
     */
    private String index;
    /**
     * 名称正则,匹配名称的规则
     */
    private Integer namePattern;
    /**
     * 参数的描述
     */
    private String desc;

}
