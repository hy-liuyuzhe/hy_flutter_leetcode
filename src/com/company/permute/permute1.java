package com.company.permute;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class permute1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permutation(nums));
    }

    private static ArrayList<List<Integer>> permutation(int[] array) {
        int len = array.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(array, 0, len, used, path, ans);
        return ans;
    }

    private static void dfs2(int[] array, int depth, int len, boolean[] used, Deque<Integer> path, ArrayList<List<Integer>> ans) {
        if (len == depth) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < array.length; i++) {
                int num = array[i];
                if (!used[i]) {
                    path.add(num);
                    used[i] = true;
                    dfs2(array, depth + 1, len, used, path, ans);
                    used[i] = false;
                    path.removeLast();
                }
            }
        }
    }
}
