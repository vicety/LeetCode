package com.company.leetCode;

import java.util.Stack;

public class P121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int now = Integer.MAX_VALUE;
        for (int price : prices) {
            if(price < now) now = price;
            else ans = Math.max(ans, price - now);
        }
        return ans;
    }
}
