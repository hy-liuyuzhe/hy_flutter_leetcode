package com.company.tree;

import com.company.link.ListNodeFactory;
import com.company.sort.ListNode;

/**
 * 1367. 二叉树中的列表
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class LeetCode_1367_二叉树中的列表 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        ListNode listNode = ListNodeFactory.create();
        System.out.println(isSubPath(listNode,treeNode));
    }

    /**
     * 前序遍历,从根节点开始不断尝试和链表头去匹配（使用isSub方法）
     * isSub拿节点和链表去做匹配，如果未满足就换个根节点（让左右儿子上）继续匹配（调用isSubPath）
     */
    private static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null){//完全匹配了
            return true;
        }
        if (root==null){//未匹配，树不够用了
            return false;
        }
        /*匹配查找一定要从链表头开始*/
        //先判断当前的节点，如果不对，再看左子树和右子树呗
        return isSub(head,root) ||
                isSubPath(head,root.left) /*从左树匹配*/ ||
                isSubPath(head,root.right)/*右树匹配*/;
    }

    private static boolean isSub(ListNode head, TreeNode node) {
        if (head == null){//完全匹配了
            return true;
        }
        if (node==null){//未匹配，树不够用了
            return false;
        }
        if (head.val != node.val){//值不对
            return false;
        }
        //左右2遍有一个满足即可
        return isSub(head.next,node.left) || isSub(head.next,node.right);
    }
}
