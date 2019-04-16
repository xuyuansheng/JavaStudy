package com.java.study.javastudy;

import com.alibaba.fastjson.JSON;

public class SimpleTestInterfaceImpl implements SimpleTestInterface {
    @Override
    public Object my(Object... param) {

            String result = JSON.toJSONString(param);
            System.out.println(result);
            return result;

    }

    @Override
    public void my2(Object... param) {
        String result = JSON.toJSONString(param);
        System.out.println(result);
    }

    @Override
    public Object noAnno(Object... param) {
        String result = JSON.toJSONString(param);
        System.out.println(result);
        return result;
    }
}
