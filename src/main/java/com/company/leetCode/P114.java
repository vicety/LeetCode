package com.company.leetCode;

import java.util.Stack;
import com.company.leetCode.utils.TreeNode;
public class P114 {
    private TreeNode toLeft(TreeNode now) {
        System.out.println(now.val);
        Stack<TreeNode> stack = new Stack<>();
        if (now.right != null) stack.add(now.right);
        while (now.left != null) {
            now = now.left;
            if (now.right != null) stack.add(now.right);
        }
        while (!stack.empty()) {
            now.left = stack.pop();
            now = toLeft(now.left);
        }
        return now;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        toLeft(root);
        TreeNode now = root;
        while (now.left != null) {
            now.right = now.left;
            now.left = null;
            now = now.right;
        }
    }
}
