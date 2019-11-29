package com.java.study.javastudy.leetcode;

import java.util.Arrays;

/**
 * @program: java-study
 * @description: 测试类
 * @author: Mr.Xu
 * @create: 2019/11/26 20:59
 */
public class NormalTest {

    public static void main(String[] args) {

        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        reverseString(a);
        System.out.println(Arrays.toString(a));
    }

    public static int reverseString(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            int qian = nums[p];
            int hou = nums[q];
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
