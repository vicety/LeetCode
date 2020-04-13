package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

/**
 * @author vicety
 * @date 2020/4/10 2:12
 */
public class P404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return solve(root, false);
    }

    private int solve(TreeNode now, boolean isLeftNode) {
        if (now.left == null && now.right == null) return isLeftNode ? now.val : 0;
        int ans = 0;
        if (now.left != null) ans += solve(now.left, true);
        if (now.right != null) ans += solve(now.right, false);
        return ans;
    }
}
