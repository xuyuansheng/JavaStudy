package com.java.study.javastudy.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-study
 * @description: 根节点到叶子节点之和
 * @author: Mr.Xu
 * @create: 2019-06-30 10:21
 */
public class RootToLeafSum {
	@Test
	public void test() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(2);

		assert 24 == sumNumbers(node);
		assert 1 == sumNumbers(new TreeNode(1));
		assert 0 == sumNumbers(null);

	}

	public int sumNumbers(TreeNode root) {

		List<String> list = new ArrayList();
		sum(root,  "", list);
		return list.stream().mapToInt(k -> Integer.valueOf(k)).reduce((k, s) -> k + s).orElse(0);

	}


	private void sum(TreeNode node, String sumNode, List list) {
		if (node == null || node.val < 0) {
			return ;
		}
		if (node.left != null) {
			sum(node.left, sumNode + node.val, list);
		}
		if (node.right != null) {
			sum(node.right, sumNode + node.val, list);
		}
		if (node.left == null && node.right == null) {
			list.add(sumNode + node.val);
		}


	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
