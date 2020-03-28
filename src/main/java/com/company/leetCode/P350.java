package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums1) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            if (cnt.get(num) != null && cnt.get(num) > 0) {
                cnt.put(num, cnt.get(num) - 1);
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
