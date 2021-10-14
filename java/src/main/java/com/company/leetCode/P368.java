package com.company.leetCode;

import java.util.*;

// WA 路径选择可能出错
public class P368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> groups = new ArrayList<>();
//        Map<Integer, Integer> max = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            for (List<Integer> group : groups) {
                if (num % group.get(group.size() - 1) == 0) group.add(num);
            }
            List<Integer> newGroup = new ArrayList<>();
            newGroup.add(num);
            groups.add(newGroup);
        }
        List<Integer> ret = new ArrayList<>();
        for (List<Integer> group : groups) if (group.size() > ret.size()) ret = group;
        return ret;
    }
}
