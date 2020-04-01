package com.company.leetCode;

public class P214_2 {
    private String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public String shortestPalindrome(String s) {
        String sReverse = reverseString(s);
        String t = s + '#' + sReverse;
        int[] next = new int[t.length() + 1];
        int j = 0, k = -1;
        next[0] = -1;
        while (j < t.length()) {
            if (k == -1 || t.charAt(j) == t.charAt(k)) next[++j] = ++k;
            else k = next[k];
        }
        return reverseString(s.substring(next[t.length()])) + s;
    }

    public static void main(String[] args) {
        P214_2 p214_2 = new P214_2();
        System.out.println(p214_2.shortestPalindrome("aabadaa"));
    }
}
