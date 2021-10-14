package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P111 {
    private int dfs(TreeNode now) {
        if(now == null) return 0;
        int lh = dfs(now.left);
        int rh = dfs(now.right);
        return (lh == 0|| rh == 0) ? lh + rh + 1 : Math.min(lh, rh) + 1;
    }


    public int minDepth(TreeNode root) {
        return dfs(root);
    }
}
