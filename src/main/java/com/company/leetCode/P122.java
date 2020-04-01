package com.company.leetCode;

public class P122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int now = Integer.MAX_VALUE;
        for (int price : prices) {
            if(price < now) now = price;
            else {
                ans += price - now;
                now = price;
            }
        }
        return ans;
    }
}
