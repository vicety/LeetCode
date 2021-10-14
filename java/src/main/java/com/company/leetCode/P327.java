package com.company.leetCode;

public class P327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) prefix[i] = prefix[i - 1] + nums[i - 1];
        return solve(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int solve(long[] nums, int st, int ed, int lower, int upper) {
        if (st >= ed) return 0;
        int mid = st + (ed - st) / 2; // mid to left
        int ret = solve(nums, st, mid, lower, upper) + solve(nums, mid + 1, ed, lower, upper);
        long[] tmp = new long[ed - st + 1];
        int pr = mid + 1, pt = 0;
        for (int i = st; i <= mid; i++) {
            int rightBound = findFirstGreater(nums, mid + 1, ed, upper + nums[i]);
            int leftBound = findFirstGeq(nums, mid + 1, ed, lower + nums[i]);
            ret += rightBound - leftBound;
            while (pr <= ed && nums[pr] <= nums[i]) tmp[pt++] = nums[pr++];
            tmp[pt++] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, st, pt);
        return ret;
    }

    private int findFirstGreater(long[] nums, int st, int ed, long target) {
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] <= target) st = mid + 1;
            else ed = mid - 1;
        }
        return st;
    }

    private int findFirstGeq(long[] nums, int st, int ed, long target) {
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] >= target) ed = mid - 1;
            else st = mid + 1;
        }
        return st;
    }

    public static void main(String[] args) {
        P327 p327 = new P327();
        System.out.println(p327.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
