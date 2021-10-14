package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        if (root == null) return ans;
        solve(ans, "", root);
        return ans;
    }

    private void solve(List<String> ans, String path, TreeNode now) {
        if (now.left == null && now.right == null) {
            path += now.val;
            ans.add(path);
            return;
        }
        path += now.val + "->";
        if (now.left != null) solve(ans, path, now.left);
        if (now.right != null) solve(ans, path, now.right);
    }
}
