package com.company.leetCode;

import java.util.Random;

public class P374 {
    private int guess(int n) {
        return (new Random()).nextInt();
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while(true) {
            int mid = l + (r - l) / 2;
            int ans = guess(mid);
            if(ans == 0) return mid;
            else if(ans < 0) r = mid - 1;
            else l = mid + 1;
        }
    }
}
