package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P77 {
    private void dfs(List<List<Integer>> ans, List<Integer> now, int n, int k, int st) {
        if (now.size() == k) {
            ans.add(new ArrayList<>(now));
            return;
        }
        for (int i = st + 1; i <= n; i++) {
            now.add(i);
            dfs(ans, now, n, k, i);
            now.remove(now.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), n, k, 0);
        return ans;
    }
}
