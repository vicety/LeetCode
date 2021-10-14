package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.Stack;

public class P236 {
//    private TreeNode findSon(TreeNode root, int val) {
//        if (root.val == val) return root;
//        TreeNode ret = null;
//        if (root.left != null && (ret = findSon(root.left, val)) != null) return ret;
//        if (root.right != null && (ret = findSon(root.right, val)) != null) return ret;
//        return null;
//    }
//
//    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
//        if (root.val == p.val) return findSon(p, q.val);
//        TreeNode ans;
//        if (findSon(root.left, p.val) != null && (ans = solve(root.right, p, q)) != null) return ans;
//        if (findSon(root.right, p.val) != null && ((ans = solve(root.left, p, q)) != null)) return ans;
//        return null;
//    }

    private boolean findPath(TreeNode root, int val, Stack<TreeNode> path) {
        path.add(root);
        if (root.val == val) return true;
        if (root.left != null && findPath(root.left, val, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, val, path)) {
            return true;
        }
        path.pop();
        return false;
    }

    private boolean findNode(TreeNode root, int val) {
        if (root.val == val) return true;
        boolean ans = false;
        if (root.left != null) ans |= findNode(root.left, val);
        if (root.right != null) ans |= findNode(root.right, val);
        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        findPath(root, p.val, stack);
        Stack<TreeNode> tmp = new Stack<>();
        while (!stack.empty()) tmp.add(stack.pop());
        stack = tmp;
        TreeNode now = null;
        while (!stack.empty()) {
            now = stack.pop();
            System.out.print(now.val);
            if (now == p) return p;
            if (now == q) return q;
            if ((stack.peek() == now.left && now.right != null && findNode(now.right, q.val))
                    || (stack.peek() == now.right && now.left != null && findNode(now.left, q.val))
            ) return now;
        }
        return null;
    }
}
