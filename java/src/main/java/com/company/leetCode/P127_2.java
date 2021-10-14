package com.company.leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P127_2 {
    int[][] mp;
    int[] vis;
    Queue<Unit> q;

    class Unit{
        int i;
        int val;

        public Unit(int i, int val) {
            this.i = i;
            this.val = val;
        }
    }

    private boolean isConnected(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) cnt++;
        return cnt == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        q = new LinkedList<>();
        wordList.add(beginWord);
        mp = new int[wordList.size()][wordList.size()];
        vis = new int[wordList.size()];
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
        q.add(new Unit(wordList.size() - 1, 1));
        vis[wordList.size() - 1] = 1;
        while (!q.isEmpty()) {
            Unit now = q.poll();
            System.out.println(String.format("%d %d", now.i, now.val));
            for (int i = 0; i < wordList.size(); i++) {
                if (vis[i] != 1 && mp[now.i][i] == 1) {
                    if(i == target) return now.val + 1;
                    q.add(new Unit(i, now.val + 1));
                    vis[i] = 1;
                }
            }
        }
        return 0;
    }
}
