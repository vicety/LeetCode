package com.company.leetCode;

public class P344 {
    public void reverseString(char[] s) {
        if (s == null) return;
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
