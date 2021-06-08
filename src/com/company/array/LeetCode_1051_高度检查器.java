package com.company.array;

import java.util.Arrays;

/**
 * 桶排序
 * 非递减: 升序
 * 计数排序
 */
public class LeetCode_1051_高度检查器 {

    /**
     * 这个2个数组请上下比较来看
     * 当前数组：[1,1,4,2,1,3]
     * 目标数组：[1,1,1,2,3,4]
     * 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
     * 在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
     * 在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
     *
     * 求最小必要移动的人数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/height-checker
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3, 12, 7};
        System.out.println(heightChecker(heights));
    }

    /**
     * 1 <= heights[i] <= 100
     * 首先利用计数排序, arr就是升序, 然后取出在该位置上的数(它是最小值的)，与原数组中位置的数比较是否一致, 不一致就是需要移动的
     */
    public static int heightChecker(int[] heights) {
        int[] arr = new int[101];
        int sum = 0;
        for (int height : heights) {
            arr[height]++;
        }
//        System.out.println(Arrays.toString(arr));
        for (int i = 1, k = 0; i < arr.length; i++) {
//            System.out.println("i: "+i +"============ j: "+j);
            while (arr[i]-- > 0) {
//                System.out.println("减减后: "+arr[i]);
                int height = heights[k++];//最后一个12, k取出也是12, 相等不需要移动, sum不会++
                if (height != i) {
                    System.out.println("i: " + i + "------------- height: " + height);
                    sum++;
                }
            }
        }
        return sum;
    }
}
