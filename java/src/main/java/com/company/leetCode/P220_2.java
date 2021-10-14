package com.company.leetCode;

import java.util.HashMap;

public class P220_2 {
    // bucket size = t + 1, (x - INT_MIN)
    private long bucketMapping(long x, long t) {
//        return (x - Integer.MIN_VALUE) / (t + 1);
        return x / (t + 1);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        HashMap<Long, Long> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long now = nums[i];
            long bucketNum = bucketMapping(now, t);
            if (mp.get(bucketNum) != null) return true;
            if (mp.get(bucketNum - 1) != null && now - mp.get(bucketNum - 1) <= t) return true;
            if (mp.get(bucketNum + 1) != null && mp.get(bucketNum + 1) - now <= t) return true;
            mp.put(bucketNum, now);
            if (i >= k) mp.remove(bucketMapping(nums[i - k], t));
        }
        return false;
    }

    public static void main(String[] args) {
        P220_2 p220 = new P220_2();
        System.out.println(p220.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
        System.out.println(-1 / 2);
    }
}
