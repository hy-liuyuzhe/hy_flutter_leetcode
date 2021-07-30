package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_784_字母大小写全排列 {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for(char c: s.toCharArray()){
            System.out.println("来个数据： "+c);
            final int n = ans.size();
            if (Character.isLetter(c)){
                for (int i = 0; i < n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            }else {
                for (int i = 0; i < n; i++) {
                    ans.get(i).append(c);
                }
            }
            System.out.println(Arrays.toString(ans.toArray()));
        }

        List<String> finalans = new ArrayList<>();
        for (StringBuilder sb: ans){
            finalans.add(sb.toString());
        }
        return finalans;
    }
}
