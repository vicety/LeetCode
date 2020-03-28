package com.company.leetCode;

import java.util.HashSet;

public class P547 {

    private int[] fa;

    private int find(int x) {
        if(fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    private void bind(int x, int y) {
        fa[find(x)] = find(y);
    }

    public int findCircleNum(int[][] M) {
        int num = M.length;
        fa = new int[num];
        for(int i = 0; i < num; i++) fa[i] = i;
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < i; j++) {
                if(M[i][j] == 1) bind(i, j);
            }
        }
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0; i < num; i++) st.add(find(i));
        return st.size();
    }
}
