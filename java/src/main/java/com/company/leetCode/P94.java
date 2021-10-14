package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.*;

public class P94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        TreeNode now = st.peek();
        while (now.left != null) {
            st.add(now.left);
            now = now.left;
        }
        while (!st.isEmpty()) {
            now = st.peek();
            ans.add(st.pop().val);
            if (now.right != null) {
                st.add(now.right);
                now = now.right;
                while (now.left != null) {
                    st.add(now.left);
                    now = now.left;
                }
            }
        }
        return ans;
    }
}
