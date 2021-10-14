package com.company.leetCode;

public class P287_4 {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        ans ^= nums[0];
        return ans;
    }

    long largest_power(long N) {
        //changing all right side bits to 1.
        N = N | (N >> 1);
        N = N | (N >> 2);
        N = N | (N >> 4);
        N = N | (N >> 8);
        N = N | (N >> 16);
        return (N + 1) >> 1;
    }


    public static void main(String[] args) {
        P287_4 p287_4 = new P287_4();
        System.out.println(1 << 31);
        System.out.println(p287_4.largest_power((long) 1 << 31));
    }
}
