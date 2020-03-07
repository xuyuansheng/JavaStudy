package com.java.study.javastudy.bean;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class JavaUtils {


    public static void main(String[] args) {
        Field[] declaredFields = FastJsonErrorBean.class.getDeclaredFields();
        for (Field f : declaredFields) {
            int modifiers = f.getModifiers();
            System.out.println(f.getName()+" "+modifiers);
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("", "", String.class);

    }

    public void test(LinkedMultiValueMap<String,Object> linkedMultiValueMap){
        test1(linkedMultiValueMap);
    }
    public void test1(Map<String, List<Object>> linkedMultiValueMap){

    }
}
