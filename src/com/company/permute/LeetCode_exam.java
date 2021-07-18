package com.company.permute;


import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_exam {

    /**
     * 字符串的排列
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     * <p>
     * 限制：
     * 1 <= s 的长度 <= 8
     * 输出结果需要去重
     */
    public static void main(String[] args) {
        String s = "abac";
        char[] array = s.toCharArray();
        Arrays.sort(array);
//        dfs(array,new ArrayList<>());
        dfs2(array,array.length,0,new boolean[array.length],new ArrayDeque<>());
        System.out.println(ans);
    }

    private static void dfs2(char[] nums, int length, int depth, boolean[] used, Deque<Character> path) {
        if (length == depth) {
            ans.add(path.stream().map(Objects::toString).collect(Collectors.joining()));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                path.add(nums[i]);
                used[i] = true;
                dfs2(nums, length, depth + 1, used, path);
                used[i] = false;
                path.removeLast();
            }
        }
    }


    static List<String> ans = new ArrayList<>();

    /**
     * this version source can not repeat element
     * @param nums
     * @param tmp
     */
    private static void dfs(char[] nums, List<Character> tmp) {
        if (nums.length == tmp.size()) {
            ans.add(tmp.stream().map((Object::toString)).collect(Collectors.joining()));
        } else {
            for (char num : nums) {
                if (!tmp.contains(num)) {
                    tmp.add(num);
                    dfs(nums, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
