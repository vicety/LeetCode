package com.company.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> s = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.get(nums[i]) != null && i - s.get(nums[i]) <= k)
                return true;
            s.put(nums[i], i);
        }
        return false;
    }
}
