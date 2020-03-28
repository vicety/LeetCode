package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

public class P235_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode now = root;
        int lower = p.val;
        int higher = q.val;
        if (lower > higher) {
            int tmp = lower;
            lower = higher;
            higher = tmp;
        }
        while (now.val > higher || now.val < lower) {
            if(lower < now.val) now = now.left;
            else now = now.right;
        }
        return now;
    }
}
