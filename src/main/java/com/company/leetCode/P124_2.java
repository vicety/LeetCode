package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P124_2 {
    private int ans = Integer.MIN_VALUE;

    private int solveOneWay(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(solveOneWay(root.left), 0);
        int right = Math.max(solveOneWay(root.right), 0);
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        solveOneWay(root);
        return ans;
    }
}
