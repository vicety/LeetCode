package com.company.leetCode;


import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution15 {
    // 1 n的做法可以到达n^2个状态中的任何状态，要看是否存在偏序
    // 如果需要增加，x + 1, y肯定好过，x, y - 1之后的所有状态
    // 画个网格图就理解了
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int target = -1 * nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                System.out.println(String.format("%d %d %d", nums[i], nums[l], nums[r]));
                int now = nums[l] + nums[r];
                if (now == target)
                    ans.add(IntStream.of(nums[i], nums[l], nums[r]).boxed().collect(Collectors.toList()));
                if (now < target) {
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    l++;
                } else {
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    r--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            i++;
        }
        return ans;
    }
}

public class P15 {
}
