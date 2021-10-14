package com.company.leetCode;

import java.util.*;

public class P202 {

    private int cal(int n) {
        int ans = 0;
        while (n > 0) {
            int now = n % 10;
            ans += now * now;
            n /= 10;
        }
        return ans;
    }

    private void dfs(Set<Integer> set, Map<Integer, List<Integer>> mp, int now) {
        set.add(now);
        if(mp.get(now) == null) return;
        for(Integer next : mp.get(now)) {
            if(!set.contains(next)) dfs(set, mp, next);
        }
    }

    public boolean isHappy(int n) {
        Map<Integer, List<Integer>> edge = new HashMap<>(1024);
        for (int i = 0; i <= 730; i++) {
            int next = cal(i);
            if(next == i) continue;
            edge.computeIfAbsent(next, k -> new ArrayList<>());
            edge.get(next).add(i);
        }
        Set<Integer> set = new HashSet<>();
        dfs(set, edge, 1);
        return set.contains(cal(n));
    }

    public static void main(String[] args) {
        P202 p202 = new P202();
        System.out.println(p202.isHappy(881));
    }
}
