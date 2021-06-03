package com.company.tree;

/**
 * 左叶子之和
 * <p>
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class LeetCode_404_左叶子之和 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode2();
//        System.out.println(sumOfLeftLeaves(treeNode, false));
        System.out.println(sumOfLeftLeaves2(treeNode));
    }

    private static int sumOfLeftLeaves(TreeNode treeNode, boolean flag) {
        if (treeNode == null)
            return 0;

//        int leaves = getAllNodeSum(treeNode);
//        int leaves = getLeftNodeSum(treeNode, flag);
        int leaves = getLeftLeavesNodeSum(treeNode, flag);

        int leftVal = sumOfLeftLeaves(treeNode.left, true);
        int rightVal = sumOfLeftLeaves(treeNode.right, false);

        return leftVal + rightVal + leaves;
    }

    /**
     * 所有左子节点的和
     */
    private static int getLeftNodeSum(TreeNode treeNode, boolean flag) {
        int leaves = 0;
        if (flag) {
            leaves += treeNode.val;
        }
        return leaves;
    }

    /**
     * 所有左叶子的和
     * flag 表示是否是左节点，left和right都为null就是叶子节点
     */
    private static int getLeftLeavesNodeSum(TreeNode treeNode, boolean flag) {
        int leaves = 0;
        if (flag && (treeNode.left == null && treeNode.right == null)) {
            leaves += treeNode.val;
        }
        return leaves;
    }

    /**
     * 所有节点的和
     *
     * @param treeNode
     */
    private static int getAllNodeSum(TreeNode treeNode) {
        return treeNode.val;
    }


    private static int sumOfLeftLeaves2(TreeNode treeNode) {
        return treeNode == null ? 0 : dfs(treeNode);
    }

    private static int dfs(TreeNode treeNode) {
        int ans = 0;

        if (treeNode.left != null) {
            ans += isLeafNode(treeNode.left) ? treeNode.left.val : dfs(treeNode.left);
        }

        if (treeNode.right != null && !isLeafNode(treeNode.right)) {
            ans+= dfs(treeNode.right);//把右节点作为根节点继续寻找
        }

        return ans;
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
