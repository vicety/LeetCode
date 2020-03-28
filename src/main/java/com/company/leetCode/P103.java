package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import com.company.leetCode.utils.TreeNode;
public class P103 {

    List<List<Integer>> ans;

    private void solve(TreeNode now, int depth) {
        if (now == null) return;
        if (ans.size() < depth) ans.add(new ArrayList<>());
        ans.get(depth - 1).add(now.val);
        solve(now.left, depth + 1);
        solve(now.right, depth + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, 1);
        for (int i = 1; i < ans.size(); i += 2) {
            for (int j = 0; j < ans.get(i).size() / 2; j++) {
                Integer tmp = ans.get(i).get(j);
                ans.get(i).set(j, ans.get(i).get(ans.get(i).size() - j - 1));
                ans.get(i).set(ans.get(i).size() - j - 1, tmp);
            }
        }
        return ans;
    }
}
