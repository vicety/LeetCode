package com.company.leetCode;


import com.company.leetCode.utils.TreeNode;

public class P98 {

    private boolean solve(TreeNode now, long high, long low) {
        if(now.val >= high || now.val <= low) return false;
        return (now.left == null || solve(now.left, now.val, low))
                && (now.right == null || solve(now.right, high, now.val));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return solve(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}
