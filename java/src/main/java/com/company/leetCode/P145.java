package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145 {
    class Node {
        TreeNode node;
        boolean mark;

        Node(TreeNode node, boolean mark) {
            this.node = node;
            this.mark = mark;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null) {
            st.add(new Node(tmp, false));
            tmp = tmp.left;
        }
        while (!st.empty()) {
            Node now = st.pop();
            if (now.mark) ans.add(now.node.val);
            else {
                now.mark = true;
                st.add(now);
                tmp = now.node.right;
                while (tmp != null) {
                    st.add(new Node(tmp, false));
                    tmp = tmp.left;
                }
            }
        }
        return ans;
    }
}
