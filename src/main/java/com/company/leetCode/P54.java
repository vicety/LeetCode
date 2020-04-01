package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P54 {
    List<Integer> ans;
    int[][] mat;

//    private void solve(int l, int r, int u, int d, String dir) {
//        if (l > r || u > d) return;
//        if (dir.equals("r")) {
//            for (int i = l; i <= r; i++) ans.add(mat[u][i]);
//            solve(l, r, u + 1, d, "d");
//        } else if (dir.equals("d")) {
//            for (int i = u; i <= d; i++) ans.add(mat[i][r]);
//            solve(l, r - 1, u, d, "l");
//        } else if (dir.equals("l")) {
//            for (int i = r; i >= l; i--) ans.add(mat[d][i]);
//            solve(l, r, u, d - 1, "u");
//        } else if (dir.equals("u")) {
//            for (int i = d; i >= u; i--) ans.add(mat[i][l]);
//            solve(l + 1, r, u, d, "r");
//        }
//    }

    private void solve(int l, int r, int u, int d) {
        int nowX = 0, nowY = 0;
        while(true) {
            if(l > r || u > d) return;
            while(nowY <= r) ans.add(mat[nowX][nowY++]);
            u++;
            nowY--;
            nowX++;
            if(l > r || u > d) return;
            while(nowX <= d) ans.add(mat[nowX++][nowY]);
            r--;
            nowX--;
            nowY--;
            if(l > r || u > d) return;
            while(nowY >= l) ans.add(mat[nowX][nowY--]);
            d--;
            nowY++;
            nowX--;
            if(l > r || u > d) return;
            while(nowX >= u) ans.add(mat[nowX--][nowY]);
            l++;
            nowX++;
            nowY++;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new ArrayList<>();
        mat = matrix;
        if(mat.length > 0 && mat[0].length > 0) solve(0, matrix[0].length - 1, 0, mat.length - 1);
        return ans;
    }
}
