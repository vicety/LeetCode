package com.company.leetCode;
import com.company.leetCode.utils.TreeNode;
public class P108 {

    private int[] nums;

    private TreeNode solve(int l, int r) {
        if(l > r) return null;
        int mid = (l + r) >> 1;
        TreeNode rt = new TreeNode(nums[mid]);
        rt.left = solve(l, mid - 1);
        rt.right = solve(mid + 1, r);
        return rt;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return solve(0, nums.length - 1);
    }
}
