package com.company.leetCode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P268 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[i] == nums.length) continue;
                int next = nums[i];
                int tmp;
                while (nums[next] != next) {
                    if(nums[next] == nums.length) break; // 不保证闭环，因此不保证开始的位置一定能被填充
                    tmp = nums[next];
                    nums[next] = next;
                    next = tmp;
                }
            }
        }
        System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
        for (int i = 0; i < nums.length; i++) if (nums[i] != i) return i;
        return nums.length;
    }

    public static void main(String[] args) {
        P268 p268 = new P268();
        System.out.println(p268.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
