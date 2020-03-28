package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

public class P101_2 {
    private boolean isSymmetricInner(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        if(l.val != r.val) return false;
        return isSymmetricInner(l.left, r.right) && isSymmetricInner(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricInner(root.left, root.right);
    }
}
