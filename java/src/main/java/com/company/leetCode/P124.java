package com.company.leetCode;

import com.company.leetCode.utils.TreeBuilder;
import com.company.leetCode.utils.TreeNode;

public class P124 {

    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }

    private int solveOneSide(TreeNode root) {
        if (root == null) return 0;
        int ans = root.val;
        int left = solveOneSide(root.left);
        int right = solveOneSide(root.right);
        return max(new int[]{ans, ans + left, ans + right});
    }

    private int solve(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = solveOneSide(root.left);
        int right = solveOneSide(root.right);
        int withRoot = root.val;
        if(left > 0) withRoot += left;
        if(right > 0) withRoot += right;
        return max(new int[]{solve(root.left), solve(root.right), withRoot});
    }

    public int maxPathSum(TreeNode root) {
        return solve(root);
    }

    public static void main(String[] args) {
        System.out.println((new P124()).maxPathSum(TreeBuilder.buildTree(new Integer[]{2, -1})))
        ;
    }
}
