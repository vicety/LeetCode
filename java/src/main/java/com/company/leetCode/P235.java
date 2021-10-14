package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

public class P235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = p.val;
        int max = q.val;
        if(min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }
        TreeNode now = root;
        while(!(now.val >= min && now.val <= max)) {
            if(now.val < min) now = now.right;
            else now = now.left;
        }
        return now;
    }
}
