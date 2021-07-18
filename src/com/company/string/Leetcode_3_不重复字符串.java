package com.company.string;

import java.util.*;

/**
 * 查找最长公共前缀
 *
 * @author liuyuzhe
 */
public class Leetcode_3_不重复字符串 {

    public static void main(String[] args) {
        String s = "loddktdji";
        System.out.println(notRepeatStringCount(s));
    }

    public static int notRepeatStringCount2(String s) {
        int max = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))){
                //map存的是索引所以+1；在求的是重复元素的位置，在这个位置从整个字符串从左边数包含多少个元素
                left = Math.max(left,map.get(s.charAt(i))+1);
            }

            map.put(s.charAt(i), i);//是重复元素，我们就覆盖其索引的值
            max = Math.max(max, i + 1 - left);//i+1表示当前字符串的length最大值了；当有重复left会被赋值，从而减去左边重复字符的索引
        }
        return max;
    }

    public static int notRepeatStringCount(String s) {
        char[] source = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        int ans = 0;
        int count = 0;
        for (char c : source) {
            if (stack.contains(c)) {
                repeatList(stack, c);
            } else {
                stack.add(c);
                count = stack.size();
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    private static void repeatList(LinkedList<Character> stack, char c) {
        stack.add(c);
        int n = stack.size();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.removeFirst() == c) {
                break;
            }
        }
    }

}
