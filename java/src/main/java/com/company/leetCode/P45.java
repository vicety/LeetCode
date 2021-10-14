package com.company.leetCode;

public class P45 {

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int cur = 0, curK = 0, l = 0, r = -1;
        while (true) {
            curK++;
            l = r + 1; r = cur;
            for(int i = l; i <= r; i++) {
                cur = Math.max(cur, i + nums[i]);
                if(cur >= nums.length - 1) return curK;
            }
        }
    }

    public static void main(String[] args) {
        P45 p45 = new P45();
        p45.jump(new int[]{2, 3, 1, 1, 4});
    }
}
