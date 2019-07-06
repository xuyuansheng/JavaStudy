package com.java.study.javastudy.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: java-study
 * @description: 两数之和
 * @author: Mr.Xu
 * @create: 2019-06-30 15:18
 */
public class TwoNumbersSum {


	@Test
	public void test() {


		int[] intArray = twoSum(Stream.of(3, 3).mapToInt(k -> k).toArray(), 6);
		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < intArray.length; i++) {
			intList.add(intArray[i]);
		}
		assert intList.containsAll(Stream.of(0, 1).collect(Collectors.toList()));
	}


	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<>(length);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[]{map.get(nums[i]), i};
			}
			int second = (target - nums[i]);
			map.put(second, i);
		}
		return new int[0];
	}


/** 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */


}
