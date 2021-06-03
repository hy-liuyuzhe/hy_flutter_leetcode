package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II

 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 */
public class LeetCode_117_填充每个节点的下一个右侧节点 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        TreeNode node = connect(treeNode);
        System.out.println(LeetCode_102_层序遍历.postOrderTraversal(node));
    }

    /**
     * 根据 根右左进行遍历, 每遍历到一个节点, 就判断其子左右节点next是否有进行关联,
     * 并且在横向循环查找是否有匹配的
     *
     */
    public static TreeNode connect(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {//是叶子节点
            return root;
        }
        if (root.left != null && root.right != null) {//完整2个分支的二叉树, 横向连接下
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static TreeNode getNextNoNullChild(TreeNode root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }


    /**
     * 采用队列层序遍历, 每遍历一次, 把一层的数据走一遍, 每一层记录上个note, 并把当前节点赋值给他
     */
    public static TreeNode connect1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < size; i++) { //层序遍历, 来赋值
                TreeNode cur = queue.poll();
                //从第二个节点开始，将前一个节点的 pre 指向当前节点
                if (i > 0) {
                    pre.next = cur; //这里不断利用临时变量, 对root树里的节点做赋值操作
                }
                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }
        return root;
    }


}
