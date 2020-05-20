package com.java.study.javastudy.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: java-study
 * @description: 测试类
 * @author: Mr.Xu
 * @create: 2019/11/26 20:59
 */
public class NormalTest {

    public static void main(String[] args) {
        Map<Integer, Integer> repeat = new HashMap<>();
        Integer put1 = repeat.put(1, 1);
        Integer put2 = repeat.put(1, 2);
        Integer put3 = repeat.put(1, 3);
        Integer put4 = repeat.put(1, 3);

        int b = new NormalTest().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1,3});

        System.out.println(b);
    }

    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            if (stack.size() == 0 || height[stack.peek()] >= height[i]) {
                stack.push(i);
                continue;
            }
            while (stack.size() > 0 && height[stack.peek()] < height[i]) {
                Integer remove = stack.pop();
                if (stack.size() <= 0) {
                    break;
                }
                int min = Math.min(height[stack.peek()], height[i]);
                int waterH = min - height[remove];
                int water = waterH * (i - stack.peek() - 1);
                ans += water;
            }
            stack.push(i);
        }
        return ans;
    }
}
