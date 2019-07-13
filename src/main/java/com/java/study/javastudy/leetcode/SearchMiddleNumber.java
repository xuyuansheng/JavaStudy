package com.java.study.javastudy.leetcode;

import org.junit.Test;

/**
 * @program: java-study
 * @description: 寻找两个有序数组的中位数
 * @author: Mr.Xu
 * @create: 2019/7/10 20:55
 */
public class SearchMiddleNumber {

    @Test
    public void test() {


        for (int i = 0; i < 10; i++) {
            System.out.println(i + "==" + splitArray(new int[i]));
        }
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        if (nums1.length == 0) {
            int index = splitArray(nums2)[0];
            if((nums2.length&1)==1){
                return nums2[index];
            }else {
                return (double) Math.addExact(nums2[index], nums2[index + 1])/2;
            }
        }else if (nums2.length == 0){
            int index = splitArray(nums1)[0];
            if((nums1.length&1)==1){
                return nums1[index];
            }else {
                return (double) Math.addExact(nums1[index], nums1[index + 1])/2;
            }
        }else {
            /*  两个数组的长度都不为 0  */

            /*  切分数组 */
            int[] splitA = splitArray(nums1);
            int[] splitB = splitArray(nums2);

            int aMin = nums1[splitA[0]];
            int bMin = nums2[splitB[0]];

            int aMax = splitA[1]==-1?0:nums1[splitA[1]];
            int bMax = splitB[1]==-1?0:nums2[splitB[1]];




        }







        /*  两个数组总长度 */
        int totalLength = nums1.length + nums2.length;
        /*  总长度的奇偶性 1:奇数 , 0: 偶数 */
        int ifUneven = totalLength & 1;
        /*  A数组分割后的左段最大值下标 */
        int ai = splitArray(nums1)[0];
        /*  A数组分割后的右段最小值下标 */
        int aj = nums1.length - ai;
        /*  首先ai和aj已经确定,所以bi和bj满足 : 总长度为奇数时->ai-aj+bi-bj=1 且 ai+aj+bi+bj=totalLength */
        int bi;
        int bj;
        if (ifUneven == 1) {
            bi = (totalLength + 1) / 2 - ai;
            bj = nums2.length - bi;
        } else {
            bi = (totalLength) / 2 - ai;
            bj = nums2.length - bi;
        }


        return 0;
    }

    public int[] splitArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            int index = (nums.length & 1) == 1 ? (nums.length + 1) / 2 : nums.length / 2;
            return new int[]{index-1,(nums.length==1?-1:index)};
        }
    }


/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
}
