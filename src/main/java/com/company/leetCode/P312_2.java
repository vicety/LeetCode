package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P312_2 {
    public int maxCoins(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        for (int num : nums) {
            if (num == 0) continue;
            tmp.add(num);
        }
        tmp.add(1);
        nums = tmp.stream().mapToInt(i -> i).toArray();
        int[][] mem = new int[nums.length][nums.length];
        for (int[] list : mem) Arrays.fill(list, -1);
        return solve(mem, nums, 0, nums.length - 1);
    }

    private int solve(int[][] mem, int[] nums, int l, int r) {
        if (l == r - 1) return 0;
        int ans = 0;
        for (int i = l + 1; i < r; i++) {
            int leftDiv = mem[l][i] == -1 ? solve(mem, nums, l, i) : mem[l][i];
            int rightDiv = mem[i][r] == -1 ? solve(mem, nums, i, r) : mem[i][r];
            ans = Math.max(ans, nums[l] * nums[r] * nums[i] + leftDiv + rightDiv);
        }
        mem[l][r] = ans;
        return ans;
    }

    public static void main(String[] args) {
        P312_2 p312_2 = new P312_2();
        System.out.println(p312_2.maxCoins(new int[]{}));
    }
}
