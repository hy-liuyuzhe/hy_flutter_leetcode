package com.company.math;

/**
 * LeetCode 58 最后一个单词的长度
 */
public class LengthLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
    }

    static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {//逆向遍历走到' '的位置取出当前字符串的length
            start--;
        }
        return end - start;
    }
}
