package com.company.leetCode;

/**
 * @author vicety
 * @date 2020/4/11 23:06
 */
public class P410 {
    public int splitArray(int[] nums, int m) {
        int maxNum = Integer.MIN_VALUE;
        long arrSum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            arrSum += num;
        }
        long l = maxNum, r = arrSum;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (canSplitLessOrEqualsThanK(nums, m, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return (int) l;
    }

    private boolean canSplitLessOrEqualsThanK(int[] nums, int m, long k) {
        int groupNum = 0;
        long groupSum = 0;
        for (int num : nums) {
            groupSum += num;
            if (groupSum > k) {
                groupNum++;
                groupSum = num;
                if (groupNum == m) return false;
            }
        }
        return true;
    }
}
