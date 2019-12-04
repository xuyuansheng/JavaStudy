package com.java.study.javastudy.jsr303;

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

        BeanValidateUtil<ParamsTest> beanValidateUtil = new BeanValidateUtil<>(new ParamsTest().setParamsOther(new ParamsOther().setParamsOtherTwo(new ParamsOtherTwo().setBool(false).setInte(3).setStr("twoStr").setIsBool(true).setIsStr("isStr"))));
        beanValidateUtil = new BeanValidateUtil<>(new ParamsTest(),false);


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

        String result = beanValidateUtil.validate(paramsTest, Groups.GroupSecond.class, Groups.GroupDefault.class);
        System.out.println(result);
    }

    @NotBlank(message = "str不能为空", groups = {Groups.GroupDefault.class})
    private String str;

    @Digits(message = "inte不符合要求", integer = 2, fraction = 0, groups = {Groups.GroupSecond.class})
    @NotNull(message = "inte不能为null", groups = {Groups.GroupSecond.class})
    private Integer inte;

    @NotNull(message = "bool不能为null", groups = {Groups.GroupDefault.class, Groups.GroupSecond.class})
    private Boolean bool;


    @Valid
    @NotNull(message = "paramsOther不能为null", groups = {Groups.GroupDefault.class, Groups.GroupSecond.class})
    private ParamsOther paramsOther;
}
