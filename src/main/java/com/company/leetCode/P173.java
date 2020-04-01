package com.company.leetCode;

import java.util.Stack;
import com.company.leetCode.utils.TreeNode;
public class P173 {
    class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            if(root == null) return;
            TreeNode now = root;
            while(now != null) {
                stack.add(now);
                now = now.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            if(node.right != null) {
                TreeNode now = node.right;
                while(now != null) {
                    stack.add(now);
                    now = now.left;
                }
            }
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
