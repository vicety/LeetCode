package com.company.leetCode;

import java.util.List;

public class P395 {
    public int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String now, int k) {
        int[] cnt = new int[26];
        for (char c : now.toCharArray()) cnt[c - 'a']++;
        int pos = -1;
        for(int i = 0; i < now.length(); i++) {
            int nowCnt = cnt[now.charAt(i) - 'a'];
            if(nowCnt > 0 && nowCnt < k) {
                pos = i;
                break;
            }
        }
        if (now.isEmpty() || pos == -1) return now.length();
        int left = dfs(now.substring(0, pos), k);
        int right = dfs(now.substring(pos + 1), k);
        return Math.max(left, right);
    }
}
