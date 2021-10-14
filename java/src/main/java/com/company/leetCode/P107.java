package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.company.leetCode.utils.TreeNode;
public class P107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, 1);
        Stack<List<Integer>> st = new Stack<>();
        for(int i = 0; i < ans.size(); i++) st.add(ans.get(i));
        ans.clear();
        while(!st.empty()) ans.add(st.pop());
        return ans;
    }

    List<List<Integer>> ans;

    private void solve(TreeNode now, int depth) {
        if (now == null) return;
        if (ans.size() < depth) ans.add(new ArrayList<>());
        ans.get(depth - 1).add(now.val);
        solve(now.left, depth + 1);
        solve(now.right, depth + 1);
    }
}
