package com.company.permute;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        String s = "abc";

        char[] array = s.toCharArray();
        dfs(array,new ArrayList<>());
        System.out.println(ans);
    }

    static List<String> ans = new ArrayList<>();

    private static void dfs(char[] nums, List<Character> tmp) {
        if (nums.length == tmp.size()){
            ans.add(tmp.stream().map((Object::toString)).collect(Collectors.joining()));
        }else {
            for (char num:nums) {
                if (!tmp.contains(num)){
                    tmp.add(num);
                    dfs(nums,tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
