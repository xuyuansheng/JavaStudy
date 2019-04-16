package com.java.study.javastudy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMethodImpl implements InvocationHandler {


    private Object object;

    public MyMethodImpl(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        MyMethodLog annotation = method.getAnnotation(MyMethodLog.class);
        if (null != annotation) {
//            有注解,所以打印日志
            System.out.println("方法执行的参数: " + JSON.toJSONString(args));
            Object obj = method.invoke(object, args);
            System.out.println("方法执行的结果: " + JSON.toJSONString(obj));
            return obj;
        } else {
            return method.invoke(object, args);
        }
    }
}
