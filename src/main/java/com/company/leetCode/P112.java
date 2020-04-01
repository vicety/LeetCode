package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P112 {
    private boolean dfs(TreeNode now, int nowSum, int target) {
        if(now == null) return nowSum == target;
        if(now.left == null) return dfs(now.right, nowSum + now.val, target);
        else if(now.right == null) return dfs(now.left, nowSum + now.val, target);
        else return dfs(now.left, nowSum + now.val, target)
                || dfs(now.right, nowSum + now.val, target);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return dfs(root, 0, sum);
    }
}
