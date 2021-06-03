package com.company.tree;

/**
 * 671. 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-14/
 */
public class LeetCode_671_二叉树中第二小的节点 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createInOrderTreeNode3();
        System.out.println(findSecondMinimumValue(treeNode));
    }

    private static int first  = Integer.MAX_VALUE;
    private static int second = Integer.MAX_VALUE;
    private static int count  = 0;

    private static int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return count == 0 ? -1 : second;
    }

    /**
     * 项目规定每个节点, root是最小的, 所以前序遍历把最小的赋值给first, 如果找到第二小的就赋值second
     *
     */
    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val < first) {
            second = first;
            first = root.val;
        } else if (root.val < second && root.val > first) { // 每次找到节点必须大于最小值first
            count++;
            second = root.val;
        }

        helper(root.left);
        helper(root.right);

    }


}
