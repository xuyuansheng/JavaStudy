package com.java.study.javastudy.jdk.concurrence;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 计算Fibonacci数列的数字总和，并返回计算结果
 */
public class FibonacciSum implements Callable<Integer> {

    private int n;
    private int[] array;
    private int sum=0;
    public FibonacciSum(int n) {
        if (n < 3) {
            n = 3;
        }
        this.n = n;
        array = new int[n];
    }

    @Override
    public Integer call() throws Exception {
        array[0] = new Random().nextInt(5);
        array[1] = new Random().nextInt(5);
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 2] + array[i - 1];
            sum=sum+array[i];
        }
        sum = sum + array[0] + array[1];
        System.out.println(Arrays.toString(array));
        return sum;
    }
}
