package com.company.leetCode;

import java.util.*;

public class P327_3 {
    private int lowbit(int x) {
        return x & -x;
    }

    private void update(int[] arr, int index, int n) {
        while (index <= n) {
            arr[index]++;
            index += lowbit(index);
        }
    }

    private int prefix(int[] arr, int index) {
        int ans = 0;
        while (index >= 1) {
            ans += arr[index];
            index -= lowbit(index);
        }
        return ans;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        Map<Long, Integer> toIndex = new HashMap<>();
        long[] prefix = new long[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) prefix[i] = prefix[i - 1] + nums[i - 1];
        Set<Long> slots = new HashSet<>();
        for (int i = 0; i < prefix.length; i++) {
            slots.add(prefix[i]);
            slots.add(prefix[i] - lower);
            slots.add(prefix[i] - upper);
        }
        Long[] slotsArr = slots.toArray(new Long[0]);
        Arrays.sort(slotsArr);
        for (int i = 0; i < slotsArr.length; i++) toIndex.put(slotsArr[i], i + 1);
        int[] bit = new int[slotsArr.length + 1];
        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int right = prefix(bit, toIndex.get(prefix[i] - lower));
            int left = prefix(bit, toIndex.get(prefix[i] - upper) - 1);
            ans += (right - left);
            update(bit, toIndex.get(prefix[i]), slotsArr.length);
        }
        return ans;
    }

    public static void main(String[] args) {
        P327_3 p327_3 = new P327_3();
        System.out.println(p327_3.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
