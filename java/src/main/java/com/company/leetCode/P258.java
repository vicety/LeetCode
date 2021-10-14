package com.company.leetCode;

import java.util.LinkedList;
import java.util.List;

public class P258 {
    public int addDigits(int num) {
        return solve(num);
    }

    private List<Integer> splitNum(int num) {
        List<Integer> ans = new LinkedList<>();
        do {
            ans.add(num % 10);
            num /= 10;
        } while (num != 0);
        return ans;
    }

    private int solve(int num) {
        List<Integer> nums = splitNum(num);
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int ans = 0;
        while (!nums.isEmpty()) {
            ans += nums.remove(0);
        }
        return solve(ans);
    }
}
