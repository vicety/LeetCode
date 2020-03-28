package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;


public class P101 {

    public boolean solve(TreeNode l, TreeNode r) {
        if (l == null || r == null || l.val != r.val) return false;
        boolean ans = true;
        if(l.left != null || r.right != null) ans = solve(l.left, r.right);
        if(l.right != null || r.left != null) ans &= solve(l.right, r.left);
        return ans;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if(root.left == null && root.right == null) return true;
        return solve(root.left, root.right);
    }
}
