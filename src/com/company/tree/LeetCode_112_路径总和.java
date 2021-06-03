package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class LeetCode_112_路径总和 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(hasPathSum(treeNode, 25));
    }


    /**
     * 通过队列把节点和每次节点累计存起来,pop出一个,判断如果是叶子节点,就判断其节点是否满足sum
     */
    private static boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            int N = queNode.size();
            for (int i = 0; i < N; i++) {
                int temp = queVal.poll();
                TreeNode now = queNode.poll();
                if (now.left == null && now.right == null) {
                    if (temp == sum) {
                        System.out.println("====");
                        return true;
                    }
                    continue;
                }

                if (now.left != null) {
                    queNode.add(now.left);
                    queVal.add(now.left.val + temp);
                }
                if (now.right != null) {
                    queNode.add(now.right);
                    queVal.add(now.right.val + temp);
                }
            }
        }
        return false;
    }

    /**
     * 递归缩小问题规模
     * 通过递归, 一旦找到叶子节点, 减去当前节点的值, 判断是否为0(满足要求), 不是叶子 遇到一个节点, 就减去当前节点来缩小问题规模
     */
    private static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }
}