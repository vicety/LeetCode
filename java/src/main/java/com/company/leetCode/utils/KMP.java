package com.company.leetCode.utils;

import java.util.ArrayList;
import java.util.List;

// ref https://www.cnblogs.com/grandyang/p/6992403.html
// ref
public class KMP {
    public static int[] buildNext(String p) {
        int[] next = new int[p.length()];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                j++;
                k++;
                if (p.charAt(k) == p.charAt(j)) next[j] = next[k];
                else next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int[] buildNextForMulti(String p) {
        int[] next = new int[p.length() + 1];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < p.length()) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                j++;
                k++;
                if(j == p.length()) next[j] = k;
                else if (p.charAt(k) == p.charAt(j)) next[j] = next[k];
                else next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static List<Integer> kmpMatchAll(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] next = buildNextForMulti(p);
        int i = 0, j = 0;
        while(i < s.length()) {
            if(j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if(j == p.length()) {
                ans.add(i - j);
                j = next[j];
            }
        }
        return ans;
    }

    public static int kmpMatch(String s, String p) {
        int[] next = buildNext(p);
        int i = 0, j = 0;
        while(i < s.length()) {
            if(j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if(j == p.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kmpMatchAll("abaaaaaaa", "aaaa"));
    }
}
