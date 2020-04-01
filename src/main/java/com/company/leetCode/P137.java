package com.company.leetCode;

public class P137 {
    public int bit(int n, int i) {return (n >> i) & 1;}

    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += (bit(num, i) == 1 ? 1 : 0);
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 3 == 1) ans += 1 << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        P137 p137 = new P137();
        System.out.println(p137.singleNumber(new int[]{1, 2, 1, 2, 1, 3, 2}));
    }
}
