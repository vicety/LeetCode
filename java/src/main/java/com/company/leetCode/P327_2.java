package com.company.leetCode;

import java.util.Map;
import java.util.TreeMap;

public class P327_2 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> mp = new TreeMap<>();
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
        mp.put((long) 0, 1);
        int ans = 0;
        for (int i = 1; i < prefix.length; i++) {
            long num = prefix[i];
            Map.Entry<Long, Integer> entry = mp.lowerEntry((long) 1);
            Map<Long, Integer> subMap = mp.subMap(num - upper, true, num - lower, true);
            for (Map.Entry<Long, Integer> entry1 : subMap.entrySet()) {
                ans += entry1.getValue();
            }
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
//        TreeMap<Integer, Integer> mp = new TreeMap<>();
//        mp.put(0, 1);
//        mp.put(2, 3);
//        mp.put(3, 4);
////        System.out.println(mp.lowerEntry(0).getKey()); // 返回小于 null
//        System.out.println(mp.lowerEntry(1).getKey()); // 小于0
//        System.out.println(mp.ceilingEntry(1).getKey()); // 返回大于等于key的第一个
//        System.out.println(mp.ceilingEntry(2).getKey()); //
//        System.out.println(mp.ceilingEntry(3).getKey()); //
//        System.out.println(mp.ceilingEntry(4).getKey()); // null
        P327_2 p327_2 = new P327_2();
        System.out.println(p327_2.countRangeSum(new int[]{-2, 5, 1}, -2, 2));
    }
}
