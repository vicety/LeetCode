package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if(set1.contains(num)) set2.add(num);
        }
        return set2.stream().mapToInt(i -> i).toArray();
    }
}
