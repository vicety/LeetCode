package com.company.leetCode;


import com.company.leetCode.utils.TreeNode;

import java.util.Stack;

public class P230_2 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while (now != null) {
            stack.push(now);
            now = now.left;
        }
        while (!stack.empty()) {
            now = stack.pop();
            if (++cnt == k) return now.val;
            now = now.right;
            while (now != null) {
                stack.push(now);
                now = now.left;
            }
        }
        return -1;
    }
}
