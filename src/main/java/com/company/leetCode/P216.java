package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P216 {
    // nowNum -> 1-9, nowN -> sum
    private void dfs(int k, int n, int nowNum, int nowK, int nowN, List<List<Integer>> ans, List<Integer> path) {
        if (nowN > n) return;
        if (nowK == k) {
            if (nowN != n) return;
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = nowNum + 1; i <= 9; i++) {
            path.add(i);
            dfs(k, n, i, nowK + 1, nowN + i, ans, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 0, 0, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        P216 p216 = new P216();
        System.out.println(p216.combinationSum3(3, 9));
    }
}
