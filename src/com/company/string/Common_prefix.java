package com.company.string;

/**
 * 查找最长公共前缀
 *
 * @author liuyuzhe
 */
public class Common_prefix {

    public static void main(String[] args) {
        String[] strs = {"leets", "etcode", "leet", "leds"}; //必须保证所有元素都满足前缀匹配

        String result = findLongestCommonPrefix(strs);
        System.out.println(result);
    }

    private static String findLongestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //不是完全包含就是-1,我就削掉prefix的最后一个字符; 对局部变量(返回值)substring剪字符, 直到剪没
            //如果==0 包含公共前缀就换下一个面试者
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
