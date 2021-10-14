package com.company.leetCode;

public class P392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() < s.length()) return false;
        int ps = 0;
        int pt = 0;
        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }
        return ps == s.length();
    }
}
