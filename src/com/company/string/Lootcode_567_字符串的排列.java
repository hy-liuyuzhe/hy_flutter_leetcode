package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lootcode_567_字符串的排列 {

    public static void main(String[] args) {
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
                if (i>0 && chars[i] == chars[i-1] && !used[i-1]){
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
