package com.company.leetCode;

import java.util.Arrays;

public class P164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max == min) return 0;
        int gapSize = (max - min) / (n - 1);
        gapSize = Math.max(gapSize, 1);  // in case [1,1,2,2] cause gapSize = 0
        int bucketNum = (max - min) / gapSize + 1;
//        System.out.printf("%d %d\n", gapSize, bucketNum);
        int[] gapMin = new int[bucketNum];
        int[] gapMax = new int[bucketNum];
        Arrays.fill(gapMax, -1);
        Arrays.fill(gapMin, -1);
        for (int num : nums) {
            int gapIndex = (num - min) / gapSize;
            if (gapMin[gapIndex] == -1) gapMin[gapIndex] = num;
            else gapMin[gapIndex] = Math.min(gapMin[gapIndex], num);
            if (gapMax[gapIndex] == -1) gapMax[gapIndex] = num;
            else gapMax[gapIndex] = Math.max(gapMax[gapIndex], num);
        }
        int ans = 0;
        int prev = gapMax[0];
        for (int i = 0; i <= gapMin.length - 2; i++) {
//            System.out.printf("%d %d %d\n", gapMin[i], gapMax[i], i);
            if (gapMax[i + 1] == -1) continue;
            ans = Math.max(ans, gapMin[i + 1] - prev);
            prev = gapMax[i + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        P164 p164 = new P164();
        System.out.println(p164.maximumGap(new int[]{1, 3, 100}));
    }
}
