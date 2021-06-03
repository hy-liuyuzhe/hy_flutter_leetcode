package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  二叉树的完全性检验
 *  https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/hen-jian-dan-de-si-lu-dai-ma-hen-jian-ji-by-yuanyb/
 */
public class LeetCode_958_二叉树的完全性检验 {



    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPostTreeNode();
        Boolean isComplete = isCompleteTree(treeNode);
        System.out.println(isComplete);
    }

    //每一层从左边的元素开始遍历，因为从列表头取元素，列表尾部添加元素
    public static Boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        TreeNode prev = root;

        while (!queue.isEmpty()){
            TreeNode node = queue.remove();//这个弹出的元素是列表的第一个
            if (prev == null && node!=null){
                return false;
            }
            if (node !=null){
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }


}
