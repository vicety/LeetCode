package com.company.leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 树状数组做法
public class P315_2 {

    private int[] bit;

    private int lowbit(int x) {
        return x & -x;
    }

    private int sum(int pos) {
        int res = 0;
        while (pos > 0) {
            res += bit[pos];
            pos -= lowbit(pos);
        }
        return res;
    }

    private void update(int pos, int val, int n) {
        while (pos <= n) {
            bit[pos] += val;
            pos += lowbit(pos);
        }
    }

    // 按照从原数组从右到左的顺序，插入按大小顺序排序的bit中
    public List<Integer> countSmaller(int[] nums) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        bit = new int[nums.length + 1];
        int[] ans = new int[nums.length];
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        for (int i = 0; i < sortedNums.length; i++) {
            numToIndex.put(sortedNums[i], i + 1);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = sum(numToIndex.get(nums[i]) - 1); // 小于等于则不用减一
            update(numToIndex.get(nums[i]), 1, nums.length);
        }
        return IntStream.of(ans).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        P315_2 p315_2 = new P315_2();
        System.out.println(p315_2.countSmaller(new int[]{1, 2, 3, 2, 1, 1}));
    }
}
