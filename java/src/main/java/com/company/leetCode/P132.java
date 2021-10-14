package com.company.leetCode;

import java.util.*;

public class P132 {
    public int minCut(String s) {
        if(s == null || s.isEmpty()) return 0;
        Map<Integer, List<Integer>> next = new HashMap<>();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            next.put(i, new ArrayList<>(Collections.singletonList(i + 1)));
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                next.get(i).add(i + 2);
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - 1 - i; j++) {
                if (dp[j + 1][j + i - 1] == 1 && s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = 1;
                    next.get(j).add(j + i + 1);
                }
            }
        }

        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> cache = new LinkedList<>();
        q.add(0);
        int round = 0;
        boolean complete = false;
        while(true) {
            vis.addAll(q);
            while (!q.isEmpty()) {
                Integer now = q.poll();
                // System.out.println(now);
                if (now == s.length()) {
                    complete = true;
                    break;
                }
                for (Integer nextIndex : next.get(now)) {
                    if (!vis.contains(nextIndex)) cache.add(nextIndex);
                }
            }
            if(complete) break;
            q = cache;
            cache = new LinkedList<>();
            round++;
        }
        return round - 1;
    }

    public static void main(String[] args) {
        P132 p132 = new P132();
        System.out.println(p132.minCut("aab"));
    }
}
