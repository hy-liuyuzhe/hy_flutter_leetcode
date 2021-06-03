package com.company.tree;

import java.util.*;


/**
 * 1110. 删点成林
 */
public class LeetCode_1110_删点成林 {

    static Set<Integer>   deletes = new HashSet<>();
    static List<TreeNode> result  = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode2();
        List<TreeNode> treeNodes = traversal(treeNode, new int[]{2, 3});
        treeNodes.forEach(treeNode1 -> {
                    System.out.println(LeetCode_91_中序遍历.inordertraversal(treeNode1));
                }
        );
    }

    private static List<TreeNode> traversal(TreeNode root, int[] deleteArray) {
        for (int d : deleteArray) {
            deletes.add(d);
        }
        helperMe(root, true);
        return result;
    }

    /**
     * @param root
     * @param needAdd
     * @return 是否需要删除
     */
    private static boolean helperMe(TreeNode root, boolean needAdd) {
        if (root == null) {
            return false;
        }
        if (deletes.contains(root.val)) {
            if (root.left == null && root.right == null) {
                System.out.println("删除掉这个叶子节点: " + root.val);
                return true;
            } else {
                System.out.println("删除掉这个节点: " + root.val);
                addDeleteChildNode(root);
            }
            return true;
        } else {
            if (needAdd)
                result.add(root);
        }
        if (helperMe(root.left, false))
            root.left = null;
        if (helperMe(root.right, false))
            root.right = null;

        return false;
    }

    private static void addDeleteChildNode(TreeNode root) {
        if (root.left != null) {
            boolean deleteLeft = helperMe(root.left, true);
            if (deleteLeft){
                root.left = null;
            }
        }
        if (root.right != null) {
            boolean deleteRight = helperMe(root.right, true);
            if (deleteRight){
                root.right = null;
            }
        }
    }


    static List<TreeNode>   res;
    static HashSet<Integer> set;

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        /*
         *首先定义一个哈希set，用来放所有想要删掉的值
         *好处：回头在递归的时候可以只遍历整棵树一遍就完成删点成林
         */
        set = new HashSet<>();
        for (int eachNum : to_delete) {
            set.add(eachNum);
        }

        res = new LinkedList<>();

        //这里传入的 needAdd 的值为true。意思是：接下来传入的点 有可能 被添加到最终结果res中
        helper(root, true);
        return res;
    }

    /*
     *这个helper函数很有意思，需要解释一下，只要明白这个函数的返回值，参数什么意思就理解了大半
     * @return:返回值可以判断这个 传入的点 是不是需要删除的点
     * @param needAdd :该参数判断这个 点 是否应该被 加入 最终结果内
     */
    private static boolean helper(TreeNode node, boolean needAdd) {
        if (node == null)
            return false;

        //注意，如果set中有node.val的话，那么就意味着这个点需要删除
        if (set.contains(node.val)) {

            //这里依旧是传入参数 needAdd 为 true，意思同上：
            //接下来这个传入的节点 又可能 被添加入最终结果res中
            if (helper(node.left, true))
                node.left = null;
            if (helper(node.right, true))
                node.right = null;

            //直接返回，不做后续处理了，直接返回true，意思是这个点应该被删除
            return true;
        }

        //如果这个点是 期望中 需要添加的点，将之加入结果的线性表中
        if (needAdd == true)
            res.add(node);

        /*
         *仔细看,这里的needAdd是传入的false，意思是:下一个点 肯定 不会被加入最终结果res中
         *这里的 if 判断也有意思，如果判断通过的话
         *意思是: helper 返回了true，即，这个helper传入的点需要删除
         *既然这个传入的点需要被删除，那么就从这里断开：node.left = null;  or  node.right = null;
         */
        if (helper(node.left, false))
            node.left = null;
        if (helper(node.right, false))
            node.right = null;
        return false;
    }
}
