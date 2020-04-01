package com.company.leetCode;

import java.util.*;

public class P131 {
    // 有空区分一下开头addList，最后remove，和动态add remove
    private void dfs(Map<Integer, List<Integer>> next, List<List<String>> ans, List<String> path, String s, int now) {
        if(now == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (Integer nextIndex : next.get(now)) {
            path.add(s.substring(now, nextIndex));
            dfs(next, ans, path, s, nextIndex);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        Map<Integer, List<Integer>> next = new HashMap<>();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i + 1);
            next.put(i, list);
        }
        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;
        for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) == s.charAt(i + 1)) {
            dp[i][i + 1] = 1;
            next.get(i).add(i + 2);
        }
        for (int i = 2; i < s.length(); i++) {
            int bound = s.length() - 1 - i;
            for (int j = 0; j <= bound; j++) {
                if (dp[j + 1][j + i - 1] == 1 && s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = 1;
                    next.get(j).add(j + i + 1);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(next, ans, new ArrayList<>(), s, 0);
        return ans;
    }
}
