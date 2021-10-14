package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.*;

public class P230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        int nowCnt = 0;
        TreeNode now = root;
        while (now != null) {
            s.add(now);
            now = now.left;
        }
        while (!s.empty()) {
            if (++nowCnt == k) return s.pop().val;
            TreeNode tmp = s.pop();
            if (tmp.right != null) {
                tmp = tmp.right;
                while(tmp!= null) {
                    s.add(tmp);
                    tmp = tmp.left;
                }
            }
        }
        return -1;
    }
}
