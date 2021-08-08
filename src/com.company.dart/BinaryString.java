package com.company.dart;

public class BinaryString {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("10: " + Integer.toBinaryString(n));
        n = n << 1; //左移一位
        System.out.println("左移一位: "+Integer.toBinaryString(n));
        n = n >> 1; //右移一位
        System.out.println("右移一位: "+Integer.toBinaryString(n));

        int res = 15&(16-1);
        System.out.println("n & n-1: "+res);

        int ans = 6 | (6-1); //都是0才是0否则就为1
        System.out.println("n & n-1: "+ans);

        int a = 8,b=4;
        int c = a^b;
        System.out.println(c^4);
    }
}
