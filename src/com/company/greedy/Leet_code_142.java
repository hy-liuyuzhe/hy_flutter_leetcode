package com.company.greedy;

/**
 * 加油站
 */
public class Leet_code_142 {

    /**
     * 从3号加油站出发(索引3)有4升油, 开发4号站后,拥有 4-1+5=8 升油了
     */
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }


    /**
     * sum[gas]<sum(cost), 那么不可能环行一圈, 这种情况下答案是 -1
     * 对于加油站i, 如果gas[i] - cost[i]<0 ,那么不可能从这个加油站出发, 因为在往前i+1的过程中, 汽油就不够用了
     * <p>
     * int curr_tank = 0;//记录当前油数, 如果小于0,意味着无法到达下一个加油站,在当前加油站作为新的起点(重置点到上一次加油起点, 中间的加油作为起点也一定无法到达这个加油站, 所有中间忽略的点一定不行)
     */
    static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                curr_tank = 0;
                starting_station = i + 1;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

}
