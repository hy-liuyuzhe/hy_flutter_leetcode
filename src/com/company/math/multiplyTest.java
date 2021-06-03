package com.company.math;

public class multiplyTest {

//    <<      :     左移运算符，num << 1,相当于num乘以2
//    >>      :     右移运算符，num >> 1,相当于num除以2
    public static void main(String[] args) {
        System.out.println(multiply(3, 4));
    }

    /**
     * b/2 转二进制最后一位是1就 +=a, 每次b除以2, a乘以2
     */
    static int multiply(int a, int b) {
        int res = 0;
        do {
            int p = b & 1;//存放这一位
            // FIXME: 06/05/2020  除以2 赋值到b身上
            b = b >> 1;//b右移一位，下一次迭代就可以取下一位
            if (p == 1) {
                res += a;
            }
            a <<= 1; // FIXME: 06/05/2020  *2 赋值到a身上
        } while (b != 0);
        return res;
    }
}