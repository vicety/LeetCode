package com.company.leetCode;

import java.util.Random;

public class P215_2 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = partition(nums, l, r);
//            System.out.printf("%d %d %d %d\n", mid, l, r, k);
            if (mid - l + 1 == k) return nums[mid];
            else if (mid - l + 1 > k) r = mid - 1;
            else {
                k -= (mid - l + 1);
                l = mid + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {
        int now = l;
        Random ran = new Random();
        int swap = ran.nextInt(r - l + 1);
        int tmp = nums[r];
        nums[r] = nums[l + swap];
        nums[l + swap] = tmp;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[r]) {
                tmp = nums[now];
                nums[now] = nums[i];
                nums[i] = tmp;
                now++;
            }
        }
        tmp = nums[now];
        nums[now] = nums[r];
        nums[r] = tmp;
        return now;
    }

    public static void main(String[] args) {
        P215_2 p215_2 = new P215_2();
        System.out.println(p215_2.findKthLargest(new int[]{2, 1}, 2));
    }
}
