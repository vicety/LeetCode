package com.company.leetCode;

import java.util.TreeSet;

public class P363_2 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        // [a, b] exclusive, [c, d]
        for (int c = 1; c <= m; c++) {
            for (int a = 0; a < c; a++) {
                int[] localPrefix = new int[n + 1];
                for (int i = 1; i <= n; i++)
                    localPrefix[i] = localPrefix[i - 1] + prefix[c][i] - prefix[c][i - 1] - prefix[a][i] + prefix[a][i - 1];
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                for(int i = 1; i <= n; i++) {
                    Integer l = treeSet.ceiling(localPrefix[i] - k);
                    if(l != null) ans = Math.max(ans, localPrefix[i] - l);
                    treeSet.add(localPrefix[i]);
                }
            }
        }
        return ans;
    }

    private int solve(int[] prefix, int l, int r, int k) {
        if (l == r) return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int mid = l + (r - l) / 2;
        ans = Math.min(ans, solve(prefix, l, mid, k));
        ans = Math.min(ans, solve(prefix, mid + 1, r, k));
        int[] tmp = new int[r - l + 1];
        int ptr = 0, pr = mid + 1;
        for (int i = l; i <= mid; i++) {
            int target = prefix[i] + k;
            int le = mid + 1, ri = r;
            while (le <= ri) {
                int mi = le + (ri - le) / 2;
                if (prefix[mi] <= target) le = mi + 1;
                else ri = mi - 1;
            }
            if (ri > mid) ans = Math.min(ans, target - prefix[ri]);
            while (pr <= r && prefix[pr] < prefix[i]) tmp[ptr++] = prefix[pr++];
            tmp[ptr++] = prefix[i];
        }
        System.arraycopy(tmp, 0, prefix, l, ptr);
        return ans;
    }

    public static void main(String[] args) {
        P363 p363 = new P363();
        int[][] mat = new int[1][3];
        mat[0] = new int[]{2, 2, -1};
        System.out.println(p363.maxSumSubmatrix(mat, 3));
    }
}
