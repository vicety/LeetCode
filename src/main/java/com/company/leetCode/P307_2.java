package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

public class P307_2 {
    class NumArray {

        public NumArray(int[] nums) {
            if (nums.length == 0) return;
            root = buildTree(nums, 0, nums.length - 1);
        }

        public void update(int i, int val) {
            rangeUpdate(i, i, val, root);
        }

        public int sumRange(int i, int j) {
            return query(i, j, root);
        }

        private Node root;

        private class Node {
            int l, r;
            Node ls, rs;
            int val;
            int lazy;

            public Node(int l, int r, Node ls, Node rs, int val, int lazy) {
                this.l = l;
                this.r = r;
                this.ls = ls;
                this.rs = rs;
                this.val = val;
                this.lazy = lazy;
            }
        }

        private void pushUp(Node node) {
            node.val = node.ls.val + node.rs.val;
        }

        private void pushDown(Node node) {
            if (node.lazy == 0) return;
            int lazy = node.lazy;
            node.lazy = 0;
            node.ls.val = lazy * (node.ls.r - node.ls.l + 1);
            node.ls.lazy = lazy;
            node.rs.val = lazy * (node.rs.r - node.rs.l + 1);
            node.rs.lazy = lazy;
        }

        private Node buildTree(int[] nums, int arrl, int arrr) {
            if (arrl == arrr) {
                return new Node(arrl, arrr, null, null, nums[arrl], 0);
            }
            int mid = arrl + (arrr - arrl) / 2;
            Node ret = new Node(arrl, arrr, null, null, 0, 0);
            ret.ls = buildTree(nums, arrl, mid);
            ret.rs = buildTree(nums, mid + 1, arrr);
            pushUp(ret);
            return ret;
        }

        private int query(int ql, int qr, Node now) {
            if (ql <= now.l && qr >= now.r) return now.val;
            pushDown(now);
            int mid = now.l + (now.r - now.l) / 2;
            int ans = 0;
            if (ql <= mid) ans += query(ql, qr, now.ls);
            if (qr > mid) ans += query(ql, qr, now.rs);
            return ans;
        }

        private void rangeUpdate(int ul, int ur, int val, Node now) {
            if (ul <= now.l && ur >= now.r) {
                now.val = (now.r - now.l + 1) * val;
                now.lazy = val;
                return;
            }
            pushDown(now);
            int mid = now.l + (now.r - now.l) / 2;
            if (ul <= mid) rangeUpdate(ul, ur, val, now.ls);
            if (ur > mid) rangeUpdate(ul, ur, val, now.rs);
            pushUp(now);
        }
    }


    public static void main(String[] args) {
        P307_2 p307_2 = new P307_2();
        NumArray numArray = p307_2.new NumArray(new int[]{0, 9, 5, 7, 3});
        System.out.println(numArray.sumRange(4, 4));
        System.out.println(numArray.sumRange(2, 4));
//        numArray.update(1, -1);
//        numArray.update(2, 3);
//        numArray.update(0, 5);
//        numArray.update(0, -4);
//        System.out.println(numArray.sumRange(0, 2));
    }
}
