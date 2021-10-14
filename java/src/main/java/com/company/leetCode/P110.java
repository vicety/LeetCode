package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P110 {
    private int dfs(TreeNode now) {
        if (now == null) return 0;
        int leftHeight = dfs(now.left);
        int rightHeight = dfs(now.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }
}
