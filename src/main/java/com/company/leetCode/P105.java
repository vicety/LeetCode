package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P105 {

    private int[] preorder;
    private int[] inorder;

    private TreeNode solve(int pl, int pr, int il, int ir) {
        if (pl > pr || il > ir) return null;
        TreeNode rt = new TreeNode(preorder[pl]);
        int cnt = 0;
        for (int i = il; i <= ir; i++) {
            if(inorder[i] != rt.val) cnt++;
            else break;
        }
        rt.left = solve(pl + 1, pl + cnt, il, il + cnt - 1);
        rt.right = solve(pl + cnt + 1, pr, il + cnt + 1, ir);
        return rt;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return solve(0, preorder.length - 1, 0, inorder.length - 1);
    }
}
