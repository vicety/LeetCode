package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P104 {
    private int ans;

    private void solve(TreeNode now, int depth) {
        if(now == null) return;
        ans = Math.max(depth, ans);
        solve(now.left, depth + 1);
        solve(now.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        ans = 0;
        solve(root, 1);
        return ans;
    }
}
