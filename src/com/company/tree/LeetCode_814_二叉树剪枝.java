package com.company.tree;

/**
 * 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/solution/java-hou-xu-bian-li-by-zxy0917/
 */
public class LeetCode_814_二叉树剪枝 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPreTreeNode2();
        System.out.println(LeetCode_91_中序遍历.inordertraversal(treeNode));

        System.out.println(LeetCode_91_中序遍历.inordertraversal(pruneTree(treeNode)));
    }

    /**
     * 叶子节点为0会被删除
     */
    private static TreeNode pruneTree(TreeNode root) {
        if (root==null)return null;
        root.left = pruneTree(root.left);//通过递归给左右节点赋值
        root.right = pruneTree(root.right);
        //过滤器, 是否拦截, 返回原节点的值
        if (root.val==0 && root.left ==null && root.right == null){
            return null;
        }
        return root;
    }

}
