package com.company.leetCode.practice;

public class KMP {
    static int[] buildNext(String p) {
        int[] next = new int[p.length()];
        int j = 0, k = -1;
        next[0] = -1;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                k++;
                j++;
                next[j] = p.charAt(j) == p.charAt(k) ? next[k] : k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    static int match(String s, String p) {
        int[] next = buildNext(p);
        int i = 0, j = 0;
        while(i < s.length()) {
            if(j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if(j == p.length()) return i - j;
        }
        return -1;
    }
}
