package com.company.leetCode;

import java.util.*;

public class P354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Set<Integer> nums = new HashSet<>();
        for (int[] envelope : envelopes) {
            nums.add(envelope[0]);
            nums.add(envelope[1]);
        }
        int[] numsSorted = nums.stream().mapToInt(i -> i).toArray();
        Arrays.sort(numsSorted);
        Map<Integer, Integer> toIndex = new HashMap<>();
        for (int i = 0; i < numsSorted.length; i++) toIndex.put(numsSorted[i], i);
        int[][] dp = new int[numsSorted.length][numsSorted.length];
        boolean[][] hasEnv = new boolean[numsSorted.length][numsSorted.length];
        int ans = 0;
        for (int[] envelope : envelopes) {
            int y = toIndex.get(envelope[0]);
            int x = toIndex.get(envelope[1]);
            hasEnv[y][x] = true;
            if (y == 0 || x == 0) dp[y][x] = 1;
        }
        for (int i = 1; i < numsSorted.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i][0]);
        }
        for (int i = 1; i < numsSorted.length; i++) {
            for (int j = 1; j < numsSorted.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (hasEnv[i][j]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[numsSorted.length - 1][numsSorted.length - 1];
    }
}
