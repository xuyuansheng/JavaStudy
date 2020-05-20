package com.java.study.javastudy.springmvc.controller;

//import cn.xuxiaobu.doc.apis.annotions.Apis;
import com.java.study.javastudy.jdk.annotations.Apis;
import com.java.study.javastudy.springmvc.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: java-study
 * @description: xbRest-doc文档
 * @author: Mr.Xu
 * @create: 2019/9/1 12:57
 */
@RestController
@RequestMapping("xbApiDocController")
@Apis
public class XbApiDocController {

    /**
     * 简单类型的参数和返回值模板
     *
     * @param name 参数名称 name
     * @return 返回值string
     *
     */
    @PostMapping("/getString")
    public String getString(@RequestParam(required = false, value = "a") String name) {
        System.out.println(name);
        return "";
    }

    /**
     * 自定义对象类型的返回 和 自定义对象的参数
     *
     * @param xbApiParams  自定义对象参数
     * @param integerParam 简单参数Integer
     * @return 自定义返回对象
     */
    @GetMapping("/getResult")
    public XbApiResult getResult(@RequestParam(required = false, value = "a") XbApiParams xbApiParams, Integer integerParam) {
        System.out.println(xbApiParams);
        return null;
    }


    /**
     * 带泛型的自定义对象类型的返回 和 自定义对象的参数
     *
     * @param xbApiParams  自定义对象参数
     * @param integerParam 简单参数Integer
     * @return 自定义返回对象
     */
    @RequestMapping("/getResultGeneric")
    public ResultVo<XbApiResult> getResultGeneric(@RequestParam(required = false, value = "a") XbApiParams xbApiParams, Integer integerParam) {
        System.out.println(xbApiParams);
        return null;
    }

    /**
     * 返回值为void时的使用,添加@Apis注解,
     * returnType = XbApiResult.class 表示此返回的类型为XbApiResult.class
     * 注意:只有方法的返回为void时returnType才会生效
     * <p>
     * paramsType = {XbApiParams.class, HttpServletResponse.class, List.class}
     * String xbApiParams, HttpServletResponse response, Integer integerParams
     * 参数的注解值一定要和方法的参数一一对应,否则会出现解析错位,
     * 如: 如果把paramsType中的HttpServletResponse.class去掉,变成如此:paramsType = {XbApiParams.class,List.class},解析的结果就会把response参数的类型变为List.class
     *
     * @param xbApiParams   自定义对象参数,参数的类型为String,实际为一个自定义对象的json对象
     * @param response      httpServletResponse
     * @param integerParams 第三个参数,Integer类型变为List
     */
    @RequestMapping("/getVoidResult")
    @Apis(returnType = XbApiResult.class, paramsType = {XbApiParams.class, HttpServletResponse.class, List.class})
    public void getVoidResult(@RequestParam(required = false, value = "a") String xbApiParams, HttpServletResponse response, Integer integerParams) {
        System.out.println(xbApiParams + integerParams);
        try {
            /*  方法无返回值,用response手动println内容 */
            response.getWriter().println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果是普通的Java项目可以使用@Apis注解标注url,参数,返回值的使用同上一个例子
     * 只有类上有此注解才能扫描到这个Url,并生效
     *
     * @param xbApiParams 参数
     * @return 返回一个List
     */
    @Apis("getApisUrl")
    public List getApisUrl(@RequestParam(required = false, value = "a") String xbApiParams) {
        System.out.println(xbApiParams);
        return null;
    }

}
