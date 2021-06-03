package com.company.program;

import com.company.tree.TreeDataFactory;
import com.company.tree.TreeNode;

import java.util.HashMap;

/**
 * 强盗抢钱3: 动态规划
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 简化一下这个问题：一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
 *
 * 我们可以用 f(o)f(o) 表示选择 oo 节点的情况下，oo 节点的子树上被选择的节点的最大权值和；g(o)g(o) 表示不选择 oo 节点的情况下，oo 节点的子树上被选择的节点的最大权值和；ll 和 rr 代表 oo 的左右孩子。
 *
 * 当 oo 被选中时，oo 的左右孩子都不能被选中，故 oo 被选中情况下子树上被选中点的最大权值和为 ll 和 rr 不被选中的最大权值和相加，即 f(o) = g(l) + g(r)f(o)=g(l)+g(r)。
 * 当 oo 不被选中时，oo 的左右孩子可以被选中，也可以不被选中。对于 oo 的某个具体的孩子 xx，它对 oo 的贡献是 xx 被选中和不被选中情况下权值和的较大值。故 g(o) = \max \{ f(l) , g(l)\}+\max\{ f(r) , g(r) \}g(o)=max{f(l),g(l)}+max{f(r),g(r)}。
 * 至此，我们可以用哈希映射来存 ff 和 gg 的函数值，用深度优先搜索的办法后序遍历这棵二叉树，我们就可以得到每一个节点的 ff 和 gg。根节点的 ff 和 gg 的最大值就是我们要找的答案。
 */
public class LeetCode_337 {

    static HashMap<TreeNode, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = TreeDataFactory.createPostTreeNode();
        System.out.println(rob(root));
    }

    static HashMap<TreeNode, Integer> f = new HashMap<>();//抢
    static HashMap<TreeNode, Integer> g = new HashMap<>();//不枪

    /**
     * 深度优先搜索递归, root的f,g最大值就是结果
     */
    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private static void dfs(TreeNode note) {
        if (note == null)
            return;
        dfs(note.left);
        dfs(note.right);
        //节点o选中, 子节点不可选
        f.put(note, note.val + g.getOrDefault(note.left, 0) + g.getOrDefault(note.right, 0));
        //节点o未选中
        int leftNote = Math.max(f.getOrDefault(note.left, 0), g.getOrDefault(note.left, 0));
        int rightNote = Math.max(f.getOrDefault(note.right, 0), g.getOrDefault(note.right, 0));

        g.put(note, leftNote + rightNote);
    }


    /**
     * 房间改为二叉树了
     */
    public static int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        //抢
        int do_it = root.val +
                (root.left == null ? 0 : rob3(root.left.left) + rob3(root.left.right)) +
                (root.right == null ? 0 : rob3(root.right.left) + rob3(root.right.right));

        //不抢
        int not_it = rob3(root.left) + rob3(root.right);

        int res = Math.max(do_it, not_it);
        memo.put(root, res);
        return res;
    }

    /**
     * 优化版本
     * 数组索引 0表选中, 1未选中
     * <p>
     * l, r 左右孩子
     */
    public static int rob2(TreeNode root) {
        int[] rootStatus = dfs2(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private static int[] dfs2(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};

        int[] l = dfs2(node.left);
        int[] r = dfs2(node.right);

        int selected = node.val + l[1] + r[1];

        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
