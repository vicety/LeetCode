package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return ans;
        int p1 = 0, p2 = 0;
        while (ans.size() < k) {
            ans.add(Arrays.asList(nums1[p1], nums2[p2]));
            if (p1 == nums1.length - 1 && p2 == nums2.length - 1) break;
            else if (p1 == nums1.length - 1) p2++;
            else if (p2 == nums2.length - 1) p1++;
            else {
                if(nums1[p1 + 1] > nums2[p2 + 1]) p2++;
                else p1++;
            }
        }
        return ans;
    }
}
