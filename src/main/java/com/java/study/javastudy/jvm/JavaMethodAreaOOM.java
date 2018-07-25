package com.java.study.javastudy.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区溢出： 方法区用于存放Class的相关信息，如类名、访问修饰符、常量池、字段描述、方法描述等。
 * 测试思路：借助CGLib 产生大量动态类填到啊方法区，直到方法区溢出
 *  1.7 及以下 VM Args :  -XX:PermSize=10M   -XX:MaxPermSize=10M
 *  1.8  VM Args : -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=7M
 */
public class JavaMethodAreaOOM {


    public static void main(String[] args) {

        while (true) {
            Enhancer  enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{
        private String[] a = new String[1024];
    }


}
