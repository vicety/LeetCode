package com.company.leetCode;

public class P389 {
    public char findTheDifference(String s, String t) {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for (char c : s.toCharArray()) cntS[c - 'a']++;
        for (char c : t.toCharArray()) cntT[c - 'a']++;
        for (int i = 0; i < 26; i++) if (cntS[i] != cntT[i]) return (char) ('a' + i);
        return 'a';
    }
}
