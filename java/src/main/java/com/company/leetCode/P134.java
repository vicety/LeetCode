package com.company.leetCode;

public class P134 {
    // 从何index开始，gas[i]-cost[i]的前缀和永远大于等于0，由于确保只有一个解，问题转化为找到前缀和中的最低点
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] flow = new int[gas.length];
        int[] sum = new int[gas.length + 1];
        for (int i = 0; i < gas.length; i++) {
            flow[i] = gas[i] - cost[i];
            sum[i + 1] = flow[i] + sum[i];
        }
        if(sum[sum.length - 1] < 0) return -1;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i < sum.length; i++) {
            if(sum[i] < min) {
                min = sum[i];
                ans = i;
            }
        }
        return ans % gas.length;
    }
}
