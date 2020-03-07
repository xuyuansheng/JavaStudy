package com.java.study.javastudy.functionalprogramming;

import com.alibaba.fastjson.TypeReference;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Mr.Xu
 * @date 2020/2/26 17:41
 */
public class RedisUtils {


    public static void main(String[] args) {
        String stringResult = RedisUtils.getFromRedisOrByFunctional("key", new TypeReference<String>() {
        }, 1L, TimeUnit.HOURS, () -> "", (r) -> false);

    }

    public static <R> R getFromRedisOrByFunctional(String key, Class<R> resultClass, Long time, TimeUnit timeUnit, Supplier<R> supplier, Predicate<R> predicate) {

        return supplier.get();

    }

    public static <R> R getFromRedisOrByFunctional(String key, TypeReference<R> typeReference, Long time, TimeUnit timeUnit, Supplier<R> supplier, Predicate<R> predicate) {

        return supplier.get();

    }

}
