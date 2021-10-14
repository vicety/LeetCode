package com.company.leetCode;

public class P214 {
    private String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) sb.append(str.charAt(i));
        return sb.toString();
    }

    public String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) i++;
        }
        if (i == s.length()) return s;
        String rev = reverseString(s.substring(i));
        return rev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
}
