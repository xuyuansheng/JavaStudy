package com.java.study.javastudy.javaparser;

import com.java.study.javastudy.controller.JavaJarRelyOnBean;
import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @program: java-study
 * @description: 泛型类解析 测试
 * @author: Mr.Xu
 * @create: 2019/8/1 21:35
 */
public class GenericityTest<T, A> {


    private String name;
    private List lists;
    private Map map;
    private Set set;
    private Integer integer;
    private Short aShort;
    private Float aFloat;
    private Character character;
    private Boolean aBoolean;


    private List<T> list;

    private A[] arrayA;

    private T t;

    @Test
    public void test() throws NoSuchMethodException {

        Type gtype = JavaJarRelyOnBean.class.getMethod("test3").getGenericReturnType();
        Class<?> type = JavaJarRelyOnBean.class.getMethod("test3").getReturnType();

        Stream.of(GenericityTest.class.getDeclaredFields())
                .forEach(field -> {
                    System.out.println(field.getName() + " " + print(field.getGenericType()));
                });

    }


    public String print(Type type) {
        if (type instanceof Class) {
            Class typeActual = Class.class.cast(type);
            return typeActual.getName() + "" + typeActual.getTypeName();
        } else if (type instanceof TypeVariable) {
            TypeVariable typeVariable = TypeVariable.class.cast(type);
            return typeVariable.getName() + "" + typeVariable.getTypeName();
        } else if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = GenericArrayType.class.cast(type);
            return genericArrayType.getGenericComponentType() + "" + genericArrayType.getTypeName();
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = ParameterizedType.class.cast(type);
            return parameterizedType.getActualTypeArguments() + "" + parameterizedType.getTypeName();
        } else {
            return "";
        }
    }
}
