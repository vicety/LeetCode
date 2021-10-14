package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.company.leetCode.utils.TreeNode;
public class P144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode now = root;
        while (now != null) {
            ans.add(now.val);
            st.add(now);
            now = now.left;
        }
        while (!st.empty()) {
            now = st.pop().right;
            while(now != null) {
                ans.add(now.val);
                st.add(now);
                now = now.left;
            }
        }
        return ans;
    }
}
