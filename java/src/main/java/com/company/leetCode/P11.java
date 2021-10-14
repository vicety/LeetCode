package com.company.leetCode;

// 难点就想不到要用two pointer
// 需要证明如果这一次从长边开始更新，后续状态不如或者等于这一次从短边更新的策略
// 1, n
// 2, n | 1, n - 1
// 3, n | 2, n - 1 | 1, n - 2

// 假设1为长边，n为短边，那么(1, n) >= (x, n) where x >= 1
// 显然此时应该更新为(1, n - 1)即更新短边
//

// 从两侧开始，每次更新短的那边

public class P11 {
    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int l = 0, r = height.length - 1;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
}
