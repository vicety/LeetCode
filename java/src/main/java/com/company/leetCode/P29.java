package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P29 {
    public int divide(int dividend, int divisor) {
        List<Long> value = new ArrayList<>();
        List<Long> weight = new ArrayList<>();
        Long multiplier = 1L;
        while (Math.abs(divisor) < Math.pow(2, 31)) {
            value.add((long) divisor);
            weight.add(multiplier);
            multiplier <<= 1;
            divisor <<= 1;
        }
        long ans = 0;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            if (dividend > 0) {
                for (int i = value.size() - 1; i >= 0; i--) {
                    if(dividend + value.get(i) > 0) {
                        dividend += value.get(i);
                        ans += value.get(i);
                    }
                }
                return (int) ans;
            }
            else {

            }
        } else {
            for (int i = value.size() - 1; i >= 0; i--) {
                if(dividend + value.get(i) < 0) {
                    dividend -= value.get(i);
                    ans += value.get(i);
                }
            }
        }
        return -1;
    }
}
