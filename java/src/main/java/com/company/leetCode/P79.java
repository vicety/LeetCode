package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P79 {

    private boolean dfs(char[][] board, boolean[][] vis, int i, int j, int m, int n, String word, int now) {
        System.out.println(String.format("%d %d", i, j));
        if (now == word.length() - 1) return true;
        boolean ret = false;
        vis[i][j] = true;
        if (i + 1 < m && !vis[i + 1][j] && board[i + 1][j] == word.charAt(now + 1))
            ret = ret || dfs(board, vis, i + 1, j, m, n, word, now + 1);
        if (i - 1 >= 0 && !vis[i - 1][j] && board[i - 1][j] == word.charAt(now + 1))
            ret = ret || dfs(board, vis, i - 1, j, m, n, word, now + 1);
        if (j + 1 < n && !vis[i][j + 1] && board[i][j + 1] == word.charAt(now + 1))
            ret = ret || dfs(board, vis, i, j + 1, m, n, word, now + 1);
        if (j - 1 >= 0 && !vis[i][j - 1] && board[i][j - 1] == word.charAt(now + 1))
            ret = ret || dfs(board, vis, i, j - 1, m, n, word, now + 1);
        vis[i][j] = false;
        return ret;
    }

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        if (board.length == 0) return false;
        List<List<Integer>>[] mp = new ArrayList[256];
        for (int i = 0; i < 256; i++) mp[i] = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(String.format("%d %d %c", i, j, board[i][j]));
                System.out.println((int) board[i][j]);
                mp[(int) board[i][j]].add(new ArrayList<Integer>(
                        IntStream.of(i, j).boxed().collect(Collectors.toList())
                ));
            }
        }
        for (int i = 0; i < mp[(int) word.charAt(0)].size(); i++) {
            System.out.println((int) word.charAt(0));
            int x = mp[(int) word.charAt(0)].get(i).get(0);
            int y = mp[(int) word.charAt(0)].get(i).get(1);
            System.out.println(String.format("x:%d y:%d", x, y));
            boolean[][] vis = new boolean[m][n];
            if (dfs(board, vis, x, y, m, n, word, 0)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P79 p79 = new P79();
        char[][] ch = new char[3][];
        ch[0] = new char[]{'A', 'B', 'C', 'E'};
        ch[1] = new char[]{'S', 'F', 'C', 'S'};
        ch[2] = new char[]{'A', 'D', 'E', 'E'};
        p79.exist(ch, "SEE");
    }
}
