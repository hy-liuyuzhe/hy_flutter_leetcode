package com.company.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序序遍历
 */
public class LeetCode_144_前序遍历 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPreTreeNode();
        System.out.println(frontOrderTraversal(treeNode));
    }

    private static List<Integer> frontOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    /**
     * 从root开始, 找左根节点, 左根节点找不到, 再从右根节点,
     *
     * 先把根节点save, 然后递归把每一层的左子节点save, 反向回递归save 右子节点
     */
    private static void helper(TreeNode root, List<Integer> list) {
        if (root==null)return;
        list.add(root.val);
        //如果right在上面,  会先走右子树;根右左
        helper(root.left,list);
        helper(root.right,list);
    }

}
