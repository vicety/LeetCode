package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import com.company.leetCode.utils.TreeNode;
public class P199 {
    private int nowMax;
    private List<Integer> ans;

    void dfs(TreeNode now, int depth) {
        if(now == null) return;
        if(depth > nowMax) {
            nowMax = depth;
            ans.add(now.val);
        }
        dfs(now.right, depth + 1);
        dfs(now.left, depth + 1);
    }


    public List<Integer> rightSideView(TreeNode root) {
        nowMax = 0;
        ans = new ArrayList<>();
        dfs(root, 1);
        return ans;
    }
}
