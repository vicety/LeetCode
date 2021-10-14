package com.company.leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        // 后来的大的优于先来的小的
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i >= k && dq.peekFirst() <= i - k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offerLast(i);
            if(i >= k - 1) ans.add(nums[dq.peekFirst()]);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        P239 p239 = new P239();
        p239.maxSlidingWindow(new int[]{1, 4, -1}, 1);
    }
}
