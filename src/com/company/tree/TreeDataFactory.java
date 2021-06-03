package com.company.tree;

public class TreeDataFactory {


    /**
     *          6
     *
     *       4         9
     *
     *     2     5   7     10
     *
     *  1   3          8
     *
     */
    public static TreeNode createTreeNode() {
        Integer[] tree = new Integer[]{6, 4, 9, 2, 7, 1, 3, 5, 8, 10};
        TreeNode root = new TreeNode(tree[0]);

        TreeNode left1 = new TreeNode(tree[1]);
        root.left = left1;
        TreeNode right1 = new TreeNode(tree[2]);
        root.right = right1;

        TreeNode left2 = new TreeNode(tree[3]);
        left1.left = left2;//2
        left1.right = new TreeNode(tree[7]);

        TreeNode left7 = new TreeNode(tree[4]);
        right1.left = left7;//7
        right1.right = new TreeNode(tree[9]);

        left7.right = new TreeNode(tree[8]);

        left2.left = new TreeNode(tree[5]);
        left2.right = new TreeNode(tree[6]);

        return root;
    }

    /**
     *          5
     *
 *          3       4
    *
*        1    2
     *
     * @return
     */
    public static TreeNode  createPostTreeNode() {
        Integer[] tree = new Integer[]{5, 3, 4, 1, 2};
        TreeNode treeNode = new TreeNode(tree[0]);
        TreeNode left1 = new TreeNode(tree[1]);//3
        treeNode.left = left1;
        treeNode.right = new TreeNode(tree[2]);//44

        left1.left = new TreeNode(tree[3]);
        left1.right = new TreeNode(tree[4]);
        return treeNode;
    }

    /**
     *             1
     *
     *      2           5
     *
     *   3     4
     *
     */
    public static TreeNode createPreTreeNode() {
        Integer[] tree = new Integer[]{1, 2, 5, 3, 4};
        TreeNode root = new TreeNode(tree[0]);
        root.right = new TreeNode(tree[2]);

        TreeNode leftNode = new TreeNode(tree[1]);
        root.left = leftNode;
        leftNode.left = new TreeNode(tree[3]);//2
        leftNode.right = new TreeNode(tree[4]);//7

        return root;
    }

    /**
     *             1
     *
     *      2           5
     *
     *   3     4
     *
     */
    public static TreeNode createPreTreeNode2() {
        Integer[] tree = new Integer[]{1, 2, 5, 3, 4};
        TreeNode root = new TreeNode(tree[0]);
        TreeNode tempRight = new TreeNode(tree[2]);
        tempRight.left = new TreeNode(0);
        root.right = tempRight;

        TreeNode leftNode = new TreeNode(tree[1]);
        root.left = leftNode;
        leftNode.left = new TreeNode(tree[3]);//2
        leftNode.right = new TreeNode(tree[4]);//7

        return root;
    }

    /**             4
     *
     *          2       5
     *
     *      1     3
     *
     */
    public static TreeNode createInOrderTreeNode() {//中序遍历
        Integer[] tree = new Integer[]{4, 2, 5, 1, 3};
        TreeNode root = new TreeNode(tree[0]);
        root.right = new TreeNode(tree[2]);

        TreeNode leftNode = new TreeNode(tree[1]);
        root.left = leftNode;

        leftNode.left = new TreeNode(tree[3]);
        leftNode.right = new TreeNode(tree[4]);
        return root;
    }

    /**             2
     *
     *          2       5
     *
 *                   5     7
     *
     */
    public static TreeNode createTreeNode2() {//中序遍历
        Integer[] tree = new Integer[]{2, 2, 5, 5, 7};
        TreeNode root = new TreeNode(tree[0]);
        TreeNode rightNode = new TreeNode(tree[2]);
        root.right = rightNode;

        TreeNode leftNode = new TreeNode(tree[1]);
        root.left = leftNode;

        rightNode.left = new TreeNode(tree[3]);
        rightNode.right = new TreeNode(tree[4]);
        return root;
    }

    /**             1
     *
     *          2       3
     *
     *      4     5
     *
     */
    public static TreeNode createInOrderTreeNode3() {//中序遍历
        Integer[] tree = new Integer[]{1, 2, 3, 4, 5};
        TreeNode root = new TreeNode(tree[0]);
        root.right = new TreeNode(tree[2]);

        TreeNode leftNode = new TreeNode(tree[1]);
        root.left = leftNode;

        leftNode.left = new TreeNode(tree[3]);
        leftNode.right = new TreeNode(tree[4]);
        return root;
    }

}
