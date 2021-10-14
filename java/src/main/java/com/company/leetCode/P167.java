package com.company.leetCode;

public class P167 {

    public int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int ed = numbers.length - 1;
        while (st < ed) {
            int sum = numbers[st] + numbers[ed];
            if (sum == target) return new int[]{st + 1, ed + 1};
            if (sum < target) st++;
            else ed--;
        }
        return null;
    }
}
