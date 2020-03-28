package com.company.leetCode;

public class P59 {
    private boolean check(int up, int down, int left, int right) {
        return up <= down && left <= right;
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int now = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (check(up, down, left, right)) {
            for (int i = left; i <= right; i++) ans[up][i] = now++;
            up++;
            if(!check(up, down, left, right)) break;
            for(int i = up; i <= down; i++) ans[i][right] = now++;
            right--;
            if(!check(up, down, left, right)) break;
            for(int i = right; i >= left; i--) ans[down][i] = now++;
            down--;
            if(!check(up, down, left, right)) break;
            for(int i = down; i >= up; i--) ans[i][left] = now++;
            left++;
        }
        return ans;
    }
}
