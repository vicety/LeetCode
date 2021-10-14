package com.company.leetCode;

import java.util.List;

// 这个是TLE的解法
// DFS会TLE
// BFS优势在于入队的一定是最终的最优解，如ab ac bc bd cd的图，dfs会额外有遍历abcd acbd的可能
public class P127 {
    int[][] mp;
    int[] vis;
    int res;

    private boolean isConnected(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) cnt++;
        return cnt == 1;
    }

    private void dfs(int now, int target, int cnt) {
        System.out.println(String.format("%d %d %d", now, target, cnt));
        if (now == target) {
            res = Math.min(res, cnt);
            return;
        }
        vis[now] = 1;
        for (int i = 0; i < mp.length; i++) {
            if (vis[i] != 1 && mp[now][i] == 1) {
                dfs(i, target, cnt + 1);
                vis[i] = 0;
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        mp = new int[wordList.size()][wordList.size()];
        vis = new int[wordList.size()];
        res = Integer.MAX_VALUE;
        int target = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) target = i;
            for (int j = 0; j < wordList.size(); j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    mp[i][j] = 1;
                    mp[j][i] = 1;
                }
            }
        }
        if (target == -1) return 0;
        dfs(wordList.size() - 1, target, 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
