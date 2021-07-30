package com.company.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序序遍历
 */
public class LeetCode_617_合并二叉树 {


    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataFactory.createPostTreeNode();
        TreeNode treeNode2 = TreeDataFactory.createPostTreeNode();
        final TreeNode root = mergeTrees(treeNode1, treeNode2);
        System.out.println(LeetCode_102_层序遍历.postOrderTraversal(root));

    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        //当2树都存在，我们要新创建一个节点,来合并其值
        final TreeNode newNode = new TreeNode(root1.val + root2.val);
        //我们假想root节点调用这2个方法来健壮其左右节点
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }

    private static TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if ((root1 == null || root1.val == 0 && root1.left == null && root1.right == null)
                && (root2 == null || root2.val == 0 && root2.left == null && root2.right == null)) {
            return null;
        }


        final TreeNode ans = new TreeNode();
        helper(root1, root2, ans);
        return ans;
    }

    private static void helper(TreeNode node1, TreeNode node2, TreeNode ans) {
        if (node1 == null && node2 == null) return;
        if (node1 != null) {
            ans.val += node1.val;
        }
        if (node2 != null) {
            ans.val += node2.val;
        }

        final boolean hasLeft = (node1 != null && node1.left != null
                || node2 != null && node2.left != null);
        if (ans.left == null && hasLeft) {
            ans.left = new TreeNode();
        }

        final boolean hasRight = (node1 != null && node1.right != null
                || node2 != null && node2.right != null);
        if (ans.right == null && hasRight) {
            ans.right = new TreeNode();
        }
        helper(node1 == null ? null : node1.left, node2 == null ? null : node2.left, ans.left);
        helper(node1 == null ? null : node1.right, node2 == null ? null : node2.right, ans.right);
    }

}
