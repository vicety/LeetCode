package com.company.leetCode;

public class P233 {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        String s = String.valueOf(n);
        int ans = 0;
        int weight = 1;
        for (int i = s.length() - 1; i >= 0; i--, weight *= 10) {
            int prev = i == 0 ? 0 : Integer.parseInt(s.substring(0, i));
            if(s.charAt(i) > '1') ans += (prev + 1) * weight;
            else if(s.charAt(i) == '1') {
                int after = i == s.length() - 1 ? 0 : Integer.parseInt(s.substring(i + 1));
                ans += prev * weight + after + 1;
            } else ans += prev * weight;
        }
        return ans;
    }

    public static void main(String[] args) {
        P233 p233 = new P233();
        System.out.println(p233.countDigitOne(9));
    }
}
