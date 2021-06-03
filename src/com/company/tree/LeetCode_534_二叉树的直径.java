package com.company.tree;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/hot-100-9er-cha-shu-de-zhi-jing-python3-di-gui-ye-/
 *
 * 二叉树的深度与高度
 * 深度：某节点的深度是从根节点到该节点的最长路径的节点数
 * 高度：某节点的高度是从叶子节点到该节点的最长路径的节点数
 * 高度从下往上看，深度从下往下看
 * h为深度则二叉树最多有2h次幂-1个节点。h=3 最多有7个节点
 */
public class LeetCode_534_二叉树的直径 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createInOrderTreeNode3();
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    static int res = 0;

    /**
     * 直径, 不一定root节点就是最大直径, 所以应该求每一个节点的最大直径
     *
     * 节点的最大直径 = 左节点的边数 + 右节点的边数
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        res = Math.max(res, leftDepth + rightDepth); //记录直径的最大值
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
