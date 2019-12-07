package com.java.study.javastudy.jsr303;

import com.java.study.javastudy.jsr303.util.BeanValidateUtil;
import com.java.study.javastudy.jsr303.util.IsDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 参数测试
 *
 * @author Mr.Xu
 * @date 2019/12/3 15:38
 */
@Data
@Accessors(chain = true)
public class ParamsTest {

    public static void main(String[] args) {

        ParamsTest defaultBean = new ParamsTest()
                .setParamsOther(new ParamsOther()
                        .setParamsOtherTwo(new ParamsOtherTwo()
                                .setBool(false)
                                .setInte(3)
                                .setStr("twoStr")
                                .setIsBool(true)
                                .setIsStr("isStr")));
        /*  校验工具类 */
        BeanValidateUtil<ParamsTest> beanValidateUtil = new BeanValidateUtil<>(defaultBean);

//        beanValidateUtil = new BeanValidateUtil<>(new ParamsTest(),false);


        ParamsOtherTwo paramsOther2 = new ParamsOtherTwo();
        paramsOther2.setBool(true);
        paramsOther2.setInte(222);
        paramsOther2.setStr(null);

        ParamsOther paramsOther = new ParamsOther();
        paramsOther.setBool(true);
        paramsOther.setInte(2);
        paramsOther.setStr("对的");
        paramsOther.setParamsOtherTwo(paramsOther2);

        ParamsTest paramsTest = new ParamsTest();
        paramsTest.setBool(true);
        paramsTest.setInte(2);
        paramsTest.setStr("ba");
        paramsTest.setParamsOther(paramsOther);
        paramsTest.setIfData("2013-12-12");

        String result = beanValidateUtil.validate(paramsTest);
        System.out.println(result);
    }

    @NotBlank(message = "str不能为空", groups = {Groups.GroupDefault.class})
    private String str;

    @Digits(message = "inte不符合要求", integer = 2, fraction = 0, groups = {Groups.GroupSecond.class})
    @NotNull(message = "inte不能为null", groups = {Groups.GroupSecond.class})
    private Integer inte;

    @NotNull(message = "bool不能为null", groups = {Groups.GroupDefault.class, Groups.GroupSecond.class})
    private Boolean bool;

    @IsDateTime(dateOrTime = 1,message = "这不是个日期呀",formatPattern = "yyyy-MM-dd",isContainDetail = true)
    private String  ifData;

    @Valid
    @NotNull(message = "paramsOther不能为null", groups = {Groups.GroupDefault.class, Groups.GroupSecond.class})
    private ParamsOther paramsOther;
}
