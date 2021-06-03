package com.company.math;

/**
 * LeetCode10 反转整数
 */
public class ReverseMath {

    /**
     * 1.使用 x%10 等到x的最低位
     * 2.反转前的溢出检查
     * 3.计算反转结果 result = result*10+a
     * 4.每完成一个反转结果, 使用x/10去掉最低位
     */
    public static void main(String[] args) {
        //2147483650
        //2147483647
//        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(12300));
    }


    private static int reverse(int x) {
        int result = 0, lo = 0;
        while (x != 0) {
            lo = x % 10;
            //check  给的数 , 214748364 如果最后一位大于7,肯定溢出了
            if (result > Integer.MAX_VALUE / 10  //  result * 10>Integer.MAX_VALUE 溢出了
                    || ((Integer.MAX_VALUE / 10) == result && Integer.MAX_VALUE % 10 < lo)) { // (result * 10) + a > Integer.MAX_VALUE
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10
                    || (Integer.MAX_VALUE / 10 == result) && Integer.MIN_VALUE % 10 > lo) {
                return 0;
            }


            result = result * 10 + lo;
            x = x / 10;
        }
        return result;
    }

}
