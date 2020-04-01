package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class P51 {

    private int toX1(int x, int y) {
        return x + y;
    }

    private int toX2(int x, int y, int n) {
        return x + (n - 1 - y);
    }

    private void solve(int now, int n, int[] row, int[] col, int[] x1, int[] x2, List<List<Integer>> ans) {
        if (now == n) {
            ans.add(new ArrayList<>(IntStream.of(row).boxed().collect(Collectors.toList())));
            return;
        }
        for (int i = 0; i < n; i++)
            if (col[i] == 0 && x1[toX1(now, i)] == 0 && x2[toX2(now, i, n)] == 0) {
                row[now] = i;
                col[i] = 1;
                x1[toX1(now, i)] = 1;
                x2[toX2(now, i, n)] = 1;
                solve(now + 1, n, row, col, x1, x2, ans);
                col[i] = 0;
                x1[toX1(now, i)] = 0;
                x2[toX2(now, i, n)] = 0;
            }
    }

    private String buildOneLine(int i, int n) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < n; j++) {
            if(j == i) sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }

    private List<List<String>> ansToString(List<List<Integer>> intAns, int n) {
        List<List<String>> ans = new ArrayList<>();
        for(List<Integer> oneIntRes : intAns) {
            List<String> oneStrAns = new ArrayList<>();
            for(int item : oneIntRes) {
                oneStrAns.add(buildOneLine(item, n));
            }
            ans.add(oneStrAns);
        }
        return ans;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> intAns = new ArrayList<>();
        int[] row = new int[n];
        int[] col = new int[n];
        int[] x1 = new int[2 * n];
        int[] x2 = new int[2 * n];
        solve(0, n, row, col, x1, x2, intAns);
//        for(List<Integer> oneRes : ans) {
//            for(Integer num : oneRes) System.out.print(num + " ");
//            System.out.println("");
//        }
//        return null;
        return ansToString(intAns, n);

    }

    public static void main(String[] args) {
        P51 p51 = new P51();
        p51.solveNQueens(4);
    }
}