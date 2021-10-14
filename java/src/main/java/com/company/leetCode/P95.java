package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class P95 {

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        List<List<TreeNode>> dp = new ArrayList<>();
        List<TreeNode> dp0 = new ArrayList<>();
        dp0.add(null);
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            dp.add(new ArrayList<>());
            for (int mid = 1; mid <= i; mid++) {
                for (TreeNode left : dp.get(mid - 1)) {
                    for (TreeNode right : dp.get(i - mid)) {
                        TreeNode rt = new TreeNode(mid);
                        rt.left = left;
                        rt.right = copyTree(right, mid);
                        dp.get(i).add(rt);
                    }
                }
            }
        }
        return dp.get(n);
    }

    private TreeNode copyTree(TreeNode cp, int bias) {
        if (cp == null) return null;
        TreeNode rt = new TreeNode(cp.val + bias);
        rt.left = copyTree(cp.left, bias);
        rt.right = copyTree(cp.right, bias);
        return rt;
    }

    public static void main(String[] args) {
        P95 p95 = new P95();
        p95.generateTrees(3);
    }
}
