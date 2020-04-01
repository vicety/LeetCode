package com.company.leetCode;

import com.company.leetCode.utils.Node;

import java.util.Stack;
import com.company.leetCode.utils.TreeNode;
public class P222 {
    private int power(int base, int exp) {
        int ans = 1;
        while (exp-- != 0) {
            ans *= base;
        }
        return ans;
    }

    private TreeNode findNode(TreeNode root, int target) {
        TreeNode now = root;
        Stack<Integer> stack = new Stack<>();
        while(target != 1) {
            stack.add((target & 1) == 1 ? 1 : 0);
            target >>= 1;
        }
        while(!stack.empty()) {
            int action = stack.pop();
            if(action == 1) now = now.right;
            else now = now.left;
        }
        return now;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode now = root;
        int depth = 1;
        while (now.left != null) {
            now = now.left;
            depth++;
        }
        int l = power(2, depth - 1) + 1;
        int r = power(2, depth) - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            TreeNode leftNode = findNode(root, mid - 1);
            TreeNode rightNode = findNode(root, mid);
            System.out.println(mid);
            System.out.println("leftNode: " + (leftNode == null ? "null" : leftNode.val));
            System.out.println("rightNode: " + (rightNode == null ? "null" : rightNode.val));
            if(rightNode == null && leftNode != null) return mid - 1;
            else if(rightNode != null) l = mid + 1;
            else r = mid - 1;
        }
        return power(2, depth) - 1;
    }
}
