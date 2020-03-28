package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P95_2 {
    private TreeNode copyOneTree(TreeNode origin, int bias) {
        if (origin == null) return null;
        TreeNode now = new TreeNode(origin.val + bias);
        now.left = copyOneTree(origin.left, bias);
        now.right = copyOneTree(origin.right, bias);
        return now;
    }

    private List<TreeNode> copyTrees(List<List<TreeNode>> ans, int n, int bias) {
        if (bias == 0) return ans.get(n);  // save memory
        List<TreeNode> results = new ArrayList<>();
        for (TreeNode treeNode : ans.get(n)) {
            results.add(copyOneTree(treeNode, bias));
        }
        return results;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        List<List<TreeNode>> ans = new ArrayList<>();
        ans.add(Arrays.asList(new TreeNode[]{null}));
        for (int i = 1; i <= n; i++) ans.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            for (int mid = 1; mid <= i; mid++) {
                int left = mid - 1;
                int right = i - mid;
                for (TreeNode leftRoot : copyTrees(ans, left, 0)) {
                    for (TreeNode rightRoot : copyTrees(ans, right, mid)) {
                        TreeNode root = new TreeNode(mid);
                        root.left = leftRoot;
                        root.right = rightRoot;
                        ans.get(i).add(root);
                    }
                }
            }
        }
        return ans.get(n);
    }
}
