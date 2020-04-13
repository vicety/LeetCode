package com.company.leetCode;

import java.util.*;

/**
 * @author vicety
 * @date 2020/4/13 0:39
 */
public class P417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        Boolean[][] toPacific = new Boolean[m][n];
        Boolean[][] toAtlantic = new Boolean[m][n];
        for (int i = 0; i < n; i++) toPacific[0][i] = true;
        for (int i = 0; i < m; i++) toPacific[i][0] = true;
        for (int i = 0; i < n; i++) toAtlantic[m - 1][i] = true;
        for (int i = 0; i < m; i++) toAtlantic[i][n - 1] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if(i == 1 && j == 4) {
//                    System.out.println(Arrays.deepToString(toPacific));
//                    System.out.println();
//                    System.out.println(Arrays.deepToString(toAtlantic));
//                }
                if (toPacific[i][j] == null)
                    toPacific[i][j] = dfs(new HashSet<>(), i, j, m, n, toPacific, matrix, null);
                if (toAtlantic[i][j] == null)
                    toAtlantic[i][j] = dfs(new HashSet<>(), i, j, m, n, toAtlantic, matrix, null);
                if (toPacific[i][j] && toAtlantic[i][j])
                    ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }

    private int serialize(int m, int y, int x) {
        return m * y + x;
    }

    private boolean dfs(Set<Integer> vis, int y, int x, int m, int n, Boolean[][] target, int[][] matrix, Integer prevHeight) {
        if (y < 0 || y >= m || x < 0 || x >= n || (prevHeight != null && matrix[y][x] > prevHeight)) return false;
        if (target[y][x] != null) return target[y][x];
        if (vis.contains(serialize(m, y, x))) return false;
        vis.add(serialize(m, y, x));
        boolean ans = false;
        ans |= dfs(vis, y + 1, x, m, n, target, matrix, matrix[y][x]);
        ans |= dfs(vis, y - 1, x, m, n, target, matrix, matrix[y][x]);
        ans |= dfs(vis, y, x + 1, m, n, target, matrix, matrix[y][x]);
        ans |= dfs(vis, y, x - 1, m, n, target, matrix, matrix[y][x]);
        if (ans) target[y][x] = true; // 可能存在反向走的情况
        return ans;
    }

    public static void main(String[] args) {
//        Boolean bool = null;
//        if(bool) System.out.println("a");
//        else System.out.println("b");
        int[][] arr = new int[1][1];
        arr[0][0] = 1;
        System.out.println(arr);
    }
}
