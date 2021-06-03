package com.company.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
 */
public class LeetCode_91_中序遍历 {


    /**
     * 递归和迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)，h 是树的高度
     *
     */
    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createInOrderTreeNode();
        System.out.println(inordertraversal3(treeNode));
    }

    /**
     * 莫里斯遍历,改变树的结构变链表
     * 将树的右边整体的都挂在树的左边的(划重点)右叶子节点上, 直到变成一个链表形状的树，然后取右节点遍历
     */
    public static List<Integer> inordertraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();//最后把树变成一个链条
        TreeNode pre;
        while (root != null) {

            if (root.left != null) { //换位置, 把右边的树, 放入左边的节点
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;//去找左边树的右子节点
                }
                pre.right = root;

                TreeNode tmp = root;
                root = root.left;
                tmp.left = null; // original cur left be null, avoid infinite loops
            } else {
                //没有左节点,就遍历右边节点, 放入链表中
                res.add(root.val);
                root = root.right;

            }
        }
        return res;
    }

    public static List<Integer> inordertraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    /**
     * 每个节点都看做一个根节点，每次递归调用helper方法都可以看做一次根节点的运算处理
     * 左根右，依次打印遍历
     */
    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }


    /**
     * 利用栈数据结构来实现迭代,中序从左开始,每个节点本身也是根节点, 一直找到叶子节点, 一旦无子节点,
     * 就输出本身的值, 然后找右节点, 一旦找到每个右节点其实也是根节点, 就循环再找左节点;
     */
    public static List<Integer> inordertraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //入栈左子节点, 到左叶子
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //栈后进先出, pop出栈顶的元素
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

}
