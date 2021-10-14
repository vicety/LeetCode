package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P124_3 {
    private int ans = Integer.MIN_VALUE;

    private int dfs(TreeNode now) {
        if(now.left == null && now.right == null) {
            ans = Math.max(ans, now.val);
            return now.val;
        }
        int left = 0;
        if(now.left != null) left = Math.max(left, dfs(now.left));
        int right = 0;
        if(now.right != null) right = Math.max(right, dfs(now.right));
        int thisMax = now.val + left + right;
        ans = Math.max(ans, thisMax);
        return now.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
