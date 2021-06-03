package com.company.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class LeetCode_199_二叉树的右视图 {

    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(levelTraversalLastNode(treeNode));
    }


    /**
     * 利用层序遍历,拿到每一层的最后一个数
     */
    public static List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private static void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(root.val);
        }
        //赞👍 , 这里利用先调用right节点, 就变成前序遍历 根,右,左; 每次拿到的都是每一层的最右侧节点
        helper(root.right, depth + 1);
        helper(root.left, depth + 1);
    }


    private static List<Integer> levelTraversalLastNode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int N = nodes.size();
            for (int i = 0; i < N; i++) {
                TreeNode node = nodes.poll();
                if (i == N - 1) {
                    res.add(node.val);
                }
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
        }
        return res;
    }
}
