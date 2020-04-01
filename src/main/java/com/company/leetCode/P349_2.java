package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P349_2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            System.out.println(String.format("%d %d", p1, p2));
            if(nums1[p1] > nums2[p2]) p2++;
            else if(nums1[p1] < nums2[p2]) p1++;
            else {
                ans.add(nums1[p1]);
                while(p1 < nums1.length && nums1[p1] == ans.get(ans.size() - 1)) p1++;
                while(p2 < nums2.length && nums2[p2] == ans.get(ans.size() - 1)) p2++;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
