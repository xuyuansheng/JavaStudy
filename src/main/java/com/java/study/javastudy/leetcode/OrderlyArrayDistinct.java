package com.java.study.javastudy.leetcode;

import java.util.Arrays;

/**
 *
 */
public class OrderlyArrayDistinct {

    public static void main(String[] args) {

        int  array[] =new int[]{0,0,1,1,1,2,2,3,3,4};
        new OrderlyArrayDistinct().removeDuplicates(array);
        System.out.println(Arrays.toString(array));
        int length = array.length;
        for (int i = array.length; i >=2; i--) {
            if(array[i-1]==array[i-2]){

            }
        }
    }
    //思路：1，2，1，3，4，4，5，6，7，7，4，8
    // 有效数据长度：xb
    //从后往前选定一个数n，然后找到与之相同的数k，找到即停止并且删除此数n。
    //删除方式：将n之后的有效数据向前移一位（即n被删除），并且有效数据长度xb减去一
    public int removeDuplicates(int[] nums) {
        int xb=nums.length-1;
        for (int i = nums.length-1; i >0 ; i--) {
            for (int j = 0; j<i ; j++) {
                if(nums[i]==nums[j]){
                    for (int k = i; k < xb; k++) {
                        nums[k] = nums[k + 1];
                    }
                    xb--;
                    break;
                }
            }

        }
        return xb+1;
    }
}
