package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 * 二叉搜索也叫排序树, 其中序遍历是升序的一个数组, 左节点小于根,右节点大于根
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-4/
 */
public class LeetCode_173_二叉搜索树迭代器 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        BSTIterator iterator = new BSTIterator(treeNode);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    static class BSTIterator {

        Queue<Integer> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            inorderTraversal(root);
        }

        private void inorderTraversal(TreeNode root) {
            if (root == null) return;
            inorderTraversal(root.left);
            queue.add(root.val);
            inorderTraversal(root.right);
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    static class BSTIterator2 {

        Stack<TreeNode> stack = new Stack<>();
        private TreeNode cur;

        public BSTIterator2(TreeNode root) {
            this.cur = root;
        }

        /**
         * 执行中序遍历, 但只执行一次
         */
        public int next() {
            int res = -1;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {//优先把左节点放入stack
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop(); //找完左, 找右
                res = cur.val;
                cur = cur.right;
                break;
            }
            return res;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }


}
