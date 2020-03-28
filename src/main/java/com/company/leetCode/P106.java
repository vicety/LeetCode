package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
import java.util.Random;

public class P106 {
    private TreeNode solve(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir || pl > pr) return null;
        TreeNode rt = new TreeNode(postorder[pr]);
        int mid = -1;
        for (int i = il; i <= ir; i++) {
            if(inorder[i] == rt.val) {
                mid = i;
                break;
            }
        }
        int leftSize = mid - il;
        rt.left = solve(inorder, postorder, il, il +leftSize - 1, pl, pl + leftSize - 1);
        rt.right = solve(inorder, postorder, il +leftSize + 1, ir, pl +leftSize, pr - 1);
        return rt;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        return solve(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        int a = 10;
        while (a-- != 0)
            System.out.println((new Random()).nextInt(4));
    }
}
