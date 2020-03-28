package com.company.leetCode;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P283 {
    public void moveZeroes(int[] nums) {
        int pZero = 0, pNonZero = 0;
        while (pZero < nums.length && nums[pZero] != 0) pZero++;
        // no Zero
        if (pZero == nums.length) return;
        pNonZero = pZero + 1;
        while (pNonZero < nums.length && nums[pNonZero] == 0) pNonZero++;
        // all Zero
        if (pNonZero == nums.length) return;
        while (pNonZero < nums.length) {
            nums[pZero] = nums[pNonZero];
            nums[pNonZero] = 0;
            pZero++;
            while (pNonZero < nums.length && nums[pNonZero] == 0) pNonZero++;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 2, 0, 3, 0, 0, 4, 5, 0, 6, 7, 0};
        P283 p283 = new P283();
        p283.moveZeroes(test);
        System.out.println(IntStream.of(test).boxed().collect(Collectors.toList()));
    }
}
