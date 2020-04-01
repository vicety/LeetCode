package com.company.leetCode;

public class P134_2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] actualCost = new int[gas.length];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < actualCost.length; i++) {
            actualCost[i] = gas[i] - cost[i];
            sum += actualCost[i];
            if(sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        if(sum < 0) return -1;
        return (minIndex + 1) % gas.length;
    }
}
