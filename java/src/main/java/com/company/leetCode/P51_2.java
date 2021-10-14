package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P51_2 {
    private void dfs(List<List<Integer>> ansSet, int nowRow, int n, int[] row, int[] col, int[] rd, int[] ld) {
        if (nowRow == n) {
            ansSet.add(IntStream.of(row).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < n; i++) {
            int rdIndex = (n - 1 - nowRow) + i;
            int ldIndex = nowRow + i;
            if (rd[rdIndex] != 1 && ld[ldIndex] != 1 && col[i] != 1) {
                rd[rdIndex] = 1;
                ld[ldIndex] = 1;
                col[i] = 1;
                row[nowRow] = i;
                dfs(ansSet, nowRow + 1, n, row, col, rd, ld);
                row[nowRow] = 0;
                col[i] = 0;
                ld[ldIndex] = 0;
                rd[rdIndex] = 0;
            }
        }
    }

    private String getLine(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == index) sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }

    private List<String> getOneResult(List<Integer> list, int n) {
        List<String> ans = new ArrayList<>();
        for (Integer i : list) {
            ans.add(getLine(i, n));
        }
        return ans;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> ansSet = new ArrayList<>();
        int[] col = new int[n];
        int[] row = new int[n];
        int[] rd = new int[2 * n - 1];
        int[] ld = new int[2 * n - 1];
        dfs(ansSet, 0, n, row, col, rd, ld);

        List<List<String>> ans = new ArrayList<>();
        for (List<Integer> integers : ansSet) {
            ans.add(getOneResult(integers, n));
        }
        return ans;
    }
}
