package com.company.leetCode;

public class P41_3 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int now = nums[i];
                nums[i] = -1;
                while (now >= 1 && now <= nums.length) {
                    if (nums[now - 1] == -1 || nums[now - 1] == now) {
                        nums[now - 1] = now;
                        break;
                    }
                    int tmp = nums[now - 1];
                    nums[now - 1] = now;
                    now = tmp;
                }
            }
        }
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) cnt++;
            else break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        P41_3 p41_3 = new P41_3();
        System.out.println(p41_3.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(p41_3.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(p41_3.firstMissingPositive(new int[]{1, 1}));
    }
}
