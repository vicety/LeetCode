package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import com.company.leetCode.utils.TreeNode;
public class P113 {
    private void dfs(TreeNode now, List<List<Integer>> ans,
                     List<Integer> path, int nowSum, int target) {
        if (now == null) {
            if (nowSum == target) ans.add(new ArrayList<>(path));
            return;
        }
        path.add(now.val);
        if (now.left == null && now.right == null) dfs(null, ans, path, nowSum + now.val, target);
        else {
            if (now.left != null) dfs(now.left, ans, path, nowSum + now.val, target);
            if (now.right != null) dfs(now.right, ans, path, nowSum + now.val, target);
        }
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, new ArrayList<>(), 0, sum);
        return ans;
    }
}
