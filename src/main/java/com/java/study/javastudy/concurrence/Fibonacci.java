package com.java.study.javastudy.concurrence;

import java.util.Arrays;
import java.util.Random;

/**
 * 生成斐波那契数列
 */
public class Fibonacci implements Runnable {
    private int n;
    private int[] array;

    public Fibonacci(int n) {
        if (n < 3) {
            n = 3;
        }
        this.n = n;
        array = new int[n];
    }

    @Override
    public void run() {
        array[0] = new Random().nextInt(5);
        array[1] = new Random().nextInt(5);
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        System.out.println(Arrays.toString(array));
    }
}
