package com.company.permute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_77_组合 {
    public static void main(String[] args) {

        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int begin = 1;
        combine(n, begin, k, new LinkedList<>(), res);
        return res;
    }

    public static void combine(int n, int begin, int k, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = begin; i <= n; i++) {
                if (!path.contains(i)) {
                    path.add(i);
                    combine(n, i + 1, k, path, ans);
                    path.removeLast();
                }
            }
        }

    }


}
