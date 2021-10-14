package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P129 {
    private int ans = 0;

    private void dfs(TreeNode now, int num) {
        if(now == null) return;
        num = num * 10 + now.val;
        if(now.left == null && now.right == null) {
            ans += num;
            return;
        }
        dfs(now.left, num);
        dfs(now.right, num);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}
