package com.company.leetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0 || t < 0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long now = nums[i];
            long upperBound = now + t;
            long lowerBound = now - t;
            Long findUpper = treeSet.floor(upperBound);
            if (findUpper != null && findUpper >= lowerBound) return true;
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
            treeSet.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        P220 p220 = new P220();
        System.out.println(p220.containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647));
    }
}
