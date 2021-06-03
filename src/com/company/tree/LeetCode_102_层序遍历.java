package com.company.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/di-gui-he-die-dai-by-powcai-2/
 */
public class LeetCode_102_层序遍历 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(levelTraversal(treeNode));
    }

    /**
     * 利用前序遍历, 每遍历树的一层, 就保存当前层的深度, 默认从0开始, 每一层创建一个独立的集合,
     * 把树每一个节点走一遍,保存到每一个对应的集合里;
     */
    public static List<List<Integer>> postOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private static void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }
        //默认第一次进入到这个深度会添加一个集合
        if (depth == res.size()) { //深度一样使用同一个集合
            res.add(new LinkedList<>());
        }
        res.get(depth).add(root.val);
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }


    /**
     * 利用遍历, 拿到每一层的节点，利用上层节点寻找下层节点, 通过迭代取出每一层的节点保存到res集合并返回
     *
     */
    private static List<List<Integer>> levelTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int N = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }

            res.add(tmp);
        }
        return res;
    }
}
