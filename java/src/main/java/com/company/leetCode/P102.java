package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class P102 {
    List<List<Integer>> ans;

    private void solve(TreeNode now, int depth) {
        if(now == null) return;
        if(ans.size() < depth) ans.add(new ArrayList<>());
        ans.get(depth - 1).add(now.val);
        solve(now.left, depth + 1);
        solve(now.right, depth + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, 1);
        return ans;
    }
}
