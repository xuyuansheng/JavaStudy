package com.java.study.javastudy.leetcode;

import java.util.Arrays;

/**
 *
 */
public class OrderlyArrayDistinct {

    public static void main(String[] args) {

        int  array[] =new int[]{0,0,1,1,1,2,2,3,3,4};
        new OrderlyArrayDistinct().removeDuplicates2(array);
//        int  array[] =  {0,1,0,3,12,0,4,5,2};
//        new OrderlyArrayDistinct().bringTheZeroToTheEnd(array,2);
        System.out.println(Arrays.toString(array));

    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0 , j=1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
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

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * 思路： 从数组后面往前找，找到0即把0后面的非0元素往前移一位
     * 思路2： 反向思维，找非0的数字，从前向后，第一个非0放在第一位，第二个非0放在第二位，以此类推找到所有非0
     */
    public void  bringTheZeroToTheEnd(int[] nums,int type){
        switch (type){
            case 1: {
                int length=nums.length;
                int  xb=length-1;
                for (int i = length-1; i > -1; i--) {
                    if(nums[i]==0){
                        if(i==xb){//如果0是最后一个，直接xb--
                            xb--;
                        }else {
                            for (int j = i; j <xb ; j++) {
                                nums[j]=nums[j+1];
                            }
                            nums[xb]=0;
                            xb--;
                        }
                    }
                }
                break;
            }
            case 2:{
                int notZeroCount=0;//找到非0的个数
                int length=nums.length;
                for (int i = 0; i < length; i++) {
                    if(nums[i]!=0){
                        if(i!=notZeroCount){
                            nums[notZeroCount]=nums[i];
                            nums[i]=0;
                        }
                        notZeroCount++;
                    }
                }
                break;
            }
        }
    }
}
