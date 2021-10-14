package com.company.leetCode;

import java.util.Arrays;

public class P260 {
    public int[] singleNumber(int[] nums) {
        int allXor = 0;
        for (int num : nums) {
            allXor ^= num;
        }
        int diffBit = 0;
        for (int i = 0; i < 32; i++) {
            if ((allXor >> i & 1) == 1) {
                diffBit = i;
                break;
            }
        }
        System.out.println(diffBit);
        int one = 0;
        for (int num : nums) {
            if ((num >> diffBit & 1) != 1) one ^= num;
        }
        int another = allXor ^ one;
        return new int[]{one, another};
    }

    public static void main(String[] args) {
        P260 p260 = new P260();
        System.out.println(Arrays.toString(p260.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
