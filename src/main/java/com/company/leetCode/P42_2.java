package com.company.leetCode;

/**
 * @author vicety
 * @date 2020/4/11 20:59
 */
public class P42_2 {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int le = 0, ri = height.length - 1;
        int ans = 0;
        int borderMinHeight = Math.min(height[le], height[ri]);
        while (le < ri) {
            if (height[le] <= height[ri]) {
                if (height[le + 1] <= borderMinHeight) {
                    ans += borderMinHeight - height[le + 1];
                } else borderMinHeight = Math.min(height[le + 1], height[ri]);
                le++;
            } else {
                if (height[ri - 1] <= borderMinHeight) {
                    ans += borderMinHeight - height[ri - 1];
                } else borderMinHeight = Math.min(height[le], height[ri - 1]);
                ri--;
            }
        }
        return ans;
    }
}
