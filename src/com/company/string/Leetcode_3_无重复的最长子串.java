package com.company.string;

import java.util.*;

/**
 * 子串的元素必须挨着
 *
 * 子串 长度为n
 * 长度为1的子串有n个
 * 长度为2的子串有n-1个
 *
 * 长度为n的子串有1个
 * 子串的数量 n(n+1)/2
 * ---------------------
 * 子序列
 * 子序列的元素不需要挨着
 * 子序列就是组合元素
 * 长度为1的子序列是 C 下n上1
 * 长度为n的子序列有1个
 *
 *  子序列总数是 2的n次幂
 *
 * @author liuyuzhe
 */
public class Leetcode_3_无重复的最长子串 {

    public static void main(String[] args) {
        String s = "loddktdji";
        System.out.println(notRepeatStringCount2(s));
    }

    /**
     * 遍历时间复杂度搞，通过hash记住位置，一下跳转到指定索引
     */
    public static int notRepeatStringCount2(String s) {
        int max = 0;
//        key字符，value是索引
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        //left是慢指针，j是快指针
        for (int left = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))){
                //map存的是索引,指向的是重复元素的位置，我们要让慢指针+1指向不重复元素；
                //让慢指针跳跃到指定位置；避免了遍历删除
                left = Math.max(left,map.get(s.charAt(j))+1);
            }

            map.put(s.charAt(j), j);//是重复元素，我们就覆盖其索引的值
            max = Math.max(max, j + 1 - left);//j+1表示当前字符串的length最大值了；当有重复left会被赋值，从而减去左边重复字符的索引
        }
        return max;
    }

    public static int notRepeatStringCount(String s) {
        char[] source = s.toCharArray();
//        这里使用链表在判断重复元素，会遍历整个链表复杂度是O(n),应该使用hashSet
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
