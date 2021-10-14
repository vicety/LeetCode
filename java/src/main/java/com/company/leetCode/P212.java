package com.company.leetCode;

import java.util.*;

public class P212 {
    class Trie {
        class Node {
            String word;
            Node[] next = new Node[256];
        }

        public Node root = new Node();

        public void insert(String str) {
            Node now = root;
            for (char c : str.toCharArray()) {
                if (now.next[c] == null) now.next[c] = new Node();
                now = now.next[c];
            }
            now.word = str;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        Map<Character, List<Integer>> mp = new HashMap<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mp.computeIfAbsent(board[i][j], k -> new ArrayList<>());
                mp.get(board[i][j]).add(i);
                mp.get(board[i][j]).add(j);
            }
        }
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++)  trie.insert(words[i]);

        boolean[][] vis = new boolean[m][n];
        Set<String> ans = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                dfs(ans, trie.root, i, j, vis, board);
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(Set<String> ans, Trie.Node now, int y, int x, boolean[][] vis, char[][] board) {
        if (y < 0 || y >= vis.length || x < 0 || x >= vis[0].length || vis[y][x] || now.next[board[y][x]] == null)
            return;
        now = now.next[board[y][x]];
        vis[y][x] = true;
        if (now.word != null) ans.add(now.word);

        dfs(ans, now, y + 1, x, vis, board);
        dfs(ans, now, y, x + 1, vis, board);
        dfs(ans, now, y - 1, x, vis, board);
        dfs(ans, now, y, x - 1, vis, board);
        vis[y][x] = false;
    }
}
