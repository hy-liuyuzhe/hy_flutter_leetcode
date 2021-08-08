package com.company.math;

public class leetcode_202_快乐数 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        int fastRunner = n, slowRunner = n;
        do {
            fastRunner = getNext(getNext(fastRunner));
            slowRunner = getNext(slowRunner);
        } while (fastRunner != 1 && fastRunner != slowRunner);
        return fastRunner == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
}
