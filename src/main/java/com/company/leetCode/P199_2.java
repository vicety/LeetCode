package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import com.company.leetCode.utils.TreeNode;
public class P199_2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(ans, root, 0);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode node, int depth) {
        if(node == null) return;
        if(ans.size() - 1 < depth) ans.add(node.val);
        else ans.set(depth, node.val);
        dfs(ans, node.left, depth + 1);
        dfs(ans, node.right, depth + 1);
    }
}
