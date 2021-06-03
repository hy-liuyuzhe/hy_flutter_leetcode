package com.company.tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }


    public void traversalNext() {
        if (next != null) {
            System.out.println(next.val);
        }

    }
}
