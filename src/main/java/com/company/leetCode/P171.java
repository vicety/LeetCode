package com.company.leetCode;

public class P171 {
    public int titleToNumber(String s) {
        int p = 0;
        int weight = 1;
        int ans = 0;
        while(s.length() - 1 - p >= 0) {
            ans += (int) (s.charAt(s.length() - 1 - p) - 'A' + 1) * weight;
            weight *= 26;
            p++;
        }
        return ans;
    }

    public static void main(String[] args) {
        P171 p171 = new P171();
        System.out.println(p171.titleToNumber(""));
    }
}
