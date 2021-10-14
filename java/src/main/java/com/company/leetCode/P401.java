package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P401 {
    public List<String> readBinaryWatch(int num) {
        List<List<Integer>> hour = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            List<Integer> tmp = new ArrayList<>();
            solveNum(tmp, i, 0, 8, 11);
            hour.add(tmp);
        }
        List<List<Integer>> minute = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            List<Integer> tmp = new ArrayList<>();
            solveNum(tmp, i, 0, 64, 59);
            minute.add(tmp);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            //79044784
            if (i <= 4 && num - i <= 6) {
                for(int nowHour : hour.get(i)) {
                    for(int nowMinute : minute.get(num - i)) {
                        ans.add(buildTime(nowHour, nowMinute));
                    }
                }
            }
        }
        return ans;
    }

    private String buildTime(int hour, int minute) {
        return String.format("%d:%02d", hour, minute);
    }

    private void solveNum(List<Integer> ans, int n, int sum, int now, int limit) {
        if (now == 0) {
            if (sum <= limit && n == 0) ans.add(sum);
            return;
        }
        if (n > 0) solveNum(ans, n - 1, sum + now, now / 2, limit);
        solveNum(ans, n, sum, now / 2, limit);
    }

    public static void main(String[] args) {
        P401 p401 = new P401();
        System.out.println(p401.readBinaryWatch(0));
        System.out.println(String.format("%7d", 123));
    }
}
