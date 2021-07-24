package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lootcode_567_字符串的排列 {

    public static void main(String[] args) {
        //permute();
        System.out.println(stringToArray());
    }

    /**
     * 利用 pFreq数组 记每个字符种类的数量，pLen记字符length
     * 去s2中寻找子串是满足字符种类数量并且length也满足
     *
     * pattern[] pLen pCount pFreq 都是固定死的，属于s1
     *
     * text[] tLen 是固定死的，属于s2
     *
     * windCount 和 winFreq[] 是变化的，属于s2 滑动窗口的数据；与s1比较
     *
     */
    private static boolean stringToArray() {
//        String s1 = "ab", s2 = "eidbaooo";

        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";

        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < pLen; i++) {
            pFreq[pattern[i] - 'a']++;
        }
        System.out.println(Arrays.toString(pFreq));

        int pCount = 0;
        for (int i = 0; i < pFreq.length; i++) {
            if (pFreq[i] > 0) pCount++;
        }

        int left = 0, right = 0;
        //winFreq 和 pFreq 记录了2个字符串中字符的个数，当匹配与s1中字符个数一致时winCount去++
        int winCount = 0;
        while (right < tLen) {
            if (pFreq[text[right] - 'a'] > 0) {//right字符在左边字符串中存在，我们才考虑处理
                winFreq[text[right] - 'a']++;
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                    winCount++;
                }
            }
            right++;

            //字符总数已经满足
            while (pCount == winCount) {
                if (right - left == pLen) {
                    return true;
                }
                //我们来收紧窗口
                if (pFreq[text[left] - 'a'] > 0 ) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }

    private static void permute() {
        String s1 = "dinitrophenylhydrazine", s2 = "acetylphenylhydrazine";
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        permute(chars, used, chars.length, new LinkedList<>());
        System.out.println(ans);
        System.out.println(hasElement(s2));
    }

    private static boolean hasElement(String s2) {
        for (String s3 : ans) {
            if (s2.contains(s3)) {
                return true;
            }
        }
        return false;
    }

    static List<String> ans = new ArrayList<>();

    private static void permute(char[] chars, boolean[] used, int length, LinkedList<Character> tmp) {
        if (tmp.size() == length) {
            ans.add(tmp.stream().map(Object::toString).collect(Collectors.joining()));
        } else {
            for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                    continue;
                }
                char c = chars[i];
                tmp.add(c);
                used[i] = true;
                permute(chars, used, length, tmp);
                used[i] = false;
                tmp.removeLast();
            }
        }
    }
}
