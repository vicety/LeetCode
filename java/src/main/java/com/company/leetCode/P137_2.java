package com.company.leetCode;

public class P137_2 {
    private void addToState(long[] nums, int num) {
        int now = 0;
        while (num != 0) {
            int x = num % 3;
            nums[now] = (nums[now] + x) % 3;
            now++;
            num /= 3;
        }
    }

    public int singleNumber(int[] nums) {
        long[] arr = new long[32];
        for (int num : nums) addToState(arr, num);
        long ans = 0;
        long weight = 1;
        for (int i = 0; i < 32; i++) {
            System.out.printf("%d %d %d", arr[i], weight, ans);
            System.out.println();
            ans += arr[i] * weight;
            weight *= 3;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
//        System.out.println((new P137_2()).singleNumber(new int[]{-401451, -177656, -2147483646, -473874, -814645, -2147483646, -852036, -457533, -401451, -473874, -401451, -216555, -917279, -457533, -852036, -457533, -177656, -2147483646, -177656, -917279, -473874, -852036, -917279, -216555, -814645, 2147483645, -2147483648, 2147483645, -814645, 2147483645, -216555}));
        System.out.println((new P137_2()).singleNumber(new int[]{-7, -7, -3, -7}));

    }
}
