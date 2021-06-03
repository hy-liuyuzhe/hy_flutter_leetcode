package com.company.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
public class LeetCode_145_后序遍历 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPostTreeNode();
        System.out.println(postOrderTraversal(treeNode));
    }

    private static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root==null)return;
        helper(root.left,list);
        helper(root.right,list);
        list.add(root.val);
    }

}
