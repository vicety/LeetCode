package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P375 {
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return solve(new HashMap<>(), 1, n, n);
    }

    private int serialize(int l, int r, int n) {
        return (l - 1) * n + (r - 1);
    }

    private int solve(Map<Integer, Integer> mem, int l, int r, int n) {
        int key = serialize(l, r, n);
        if (l == r) return 0;
        else if (l + 1 == r) return l;
        else if (mem.containsKey(key)) return mem.get(key);
        else {
            int ans = Integer.MAX_VALUE;
            for (int i = l + 1; i < r; i++) {
                ans = Math.min(ans, i + Math.max(solve(mem, l, i - 1, n), solve(mem, i + 1, r, n)));
            }
            mem.put(key, ans);
            return ans;
        }
    }
}
