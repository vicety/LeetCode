package com.company.leetCode;

public class P260_2 {
    public int[] singleNumber(int[] nums) {
        int first = 0;
        for (int num : nums) {
            first ^= num;
        }
        int lowBitIndex = 0;
        while (first != 0) {
            if ((first & 1) == 1) break;
            first >>= 1;
            lowBitIndex++;
        }
        first = 0;
        for (int num : nums) {
            if ((num & (1 << lowBitIndex)) != 0) first ^= num;
        }
        int second = first;
        for (int num : nums) {
            second ^= num;
        }
        return new int[]{first, second};
    }
}
