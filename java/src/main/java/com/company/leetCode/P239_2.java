package com.company.leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class P239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        int cnt = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k - 1) ans[cnt++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
