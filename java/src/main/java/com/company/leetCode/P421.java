package com.company.leetCode;

/**
 * @author vicety
 * @date 2020/4/13 21:56
 */
public class P421 {
    private class Node {
        Node[] son = new Node[2];
    }

    private Node root = new Node();

    private void addNum(int n) {
        Node now = root;
        for (int i = 31; i >= 0; i--) {
            int val = (n >>> i) & 1;
            if (now.son[val] == null) now.son[val] = new Node();
            now = now.son[val];
        }
    }

    private int getMax(int n) {
        int ans = 0;
        Node now = root;
        for (int i = 31; i >= 0; i--) {
            int val = (n >>> i) & 1;
            if (now.son[val ^ 1] != null) {
                ans += (1 << i);
                now = now.son[val ^ 1];
            } else now = now.son[val];
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length <= 1) return 0;
        int ans = Integer.MIN_VALUE;
        addNum(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, getMax(nums[i]));
            addNum(nums[i]);
        }
        return ans;
    }
}
