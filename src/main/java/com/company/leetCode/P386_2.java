package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P386_2 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(ans, n, i);
        }
        return ans;
    }

    private void dfs(List<Integer> ans, int n, int now) {
        if (now > n) return;
        ans.add(now);
        now *= 10;
        for (int i = 0; i <= 9; i++) {
            dfs(ans, n, now + i);
        }
    }

    public static void main(String[] args) {
        P386_2 p386_2 = new P386_2();
        System.out.println(p386_2.lexicalOrder(203));
    }
}
