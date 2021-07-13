package com.company.string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class LeetCode_557_翻转字符串 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    private static String reverse(String s) {
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length / 2; i++) {
            char tmp = letters[i];
            letters[i] = letters[letters.length - 1 - i];
            letters[letters.length - 1 - i] = tmp;
        }
        return new String(letters);
    }

    private static String reverse2(String s) {
        char[] letters = s.toCharArray();
        for (int l = 0, r = letters.length - 1; l < r; l++, r--) {
            char tmp = letters[l];
            letters[l] = letters[r];
            letters[r] = tmp;
        }
        return new String(letters);
    }

    private static String reverseLetter(String s) {
        String[] nums = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            String letter = nums[i];
            builder.append(reverse2(letter));
            if (nums.length - 1 != i) builder.append(" ");
        }
        return builder.toString();
    }

    private static String reverseWords(String words) {
        int l = 0, r = words.length();
        StringBuilder builder = new StringBuilder();

        while (l<r){
            int start = l;

            while (l<r && words.charAt(l)!=' '){
                l++;
            }
            for (int i = start; i <l; i++) {
                builder.append(words.charAt(start+l-i-1));
            }

            if (l<r && words.charAt(l) == ' '){
                builder.append(" ");
                l++;
            }
        }

        return builder.toString();
    }

}
