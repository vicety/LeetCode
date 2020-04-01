package com.company.leetCode;

public class P844 {
    public boolean backspaceCompare(String S, String T) {
        int p1 = S.length() - 1;
        int p2 = T.length() - 1;
        int cnt1 = 0;
        int cnt2 = 0;
        while (true) {
            while (p1 >= 0) {
                if (S.charAt(p1) == '#') {
                    cnt1++;
                    p1--;
                } else if (cnt1 > 0) {
                    cnt1--;
                    p1--;
                } else break;
            }
            while (p2 >= 0) {
                if (T.charAt(p2) == '#') {
                    cnt2++;
                    p2--;
                } else if (cnt2 > 0) {
                    cnt2--;
                    p2--;
                } else break;
            }
            if(p1 < 0 && p2 < 0) return true;
            else if(p1 < 0 || p2 < 0) return false;
            if(S.charAt(p1--) != T.charAt(p2--)) return false;
        }
    }

    public static void main(String[] args) {
        P844 p844 = new P844();
        System.out.println(p844.backspaceCompare("a#c", "a"));
    }
}
