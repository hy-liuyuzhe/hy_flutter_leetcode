package com.company.tree;

import com.sun.tools.javac.util.Pair;

import java.util.LinkedList;


/**
 * 二叉树最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author liuyuzhe
 */
public class LeetCode_111_树最小深度 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPostTreeNode();
        System.out.println(minDepth2(treeNode));
    }


    /**
     * 不断的递归, 每一层加1, 左右节点取最小的, 如果遇到左右节点有一个孩子为null, 那么当前节点+1
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {// 叶子节点高度为1
            return 1;
        }

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right); //都进入到叶子节点返回0

        if (root.left == null || root.right == null) {// 单分叉节点, 其中一个height为0, 那么当前节点高度+1即可
            return leftHeight + rightHeight + 1;
        }

        return Math.min(leftHeight, rightHeight) + 1;
    }

    /**
     * 利用队列, 从根节点迭代, 一旦走到叶子节点, 说明当前节点是最小深度
     */
    public static int minDepth2(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<>(root, 1));
        }

        int current_depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.fst;
            current_depth = current.snd;

            //一旦找到叶子节点就break
            if (root.left == null && root.right == null) {
                break;
            }

            if (root.left != null) { //走下一层就深度加1
                stack.add(new Pair<>(root.left, current_depth + 1));
            }

            if (root.right != null) {
                stack.add(new Pair<>(root.right, current_depth + 1));
            }
        }

        return current_depth;
    }


}
