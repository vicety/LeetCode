package com.company.leetCode;

public class P307 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

// 区间加减版本
class NumArray {

    class Node {
        int l;
        int r;
        int val;
        int lazy;
    }

    private Node[] arr;
    private int[] nums;
    private int n;

    private int ls(int i) {
        return i << 1;
    }

    private int rs(int i) {
        return i << 1 | 1;
    }

    private void up(int rt) {
        arr[rt].val = arr[ls(rt)].val + arr[rs(rt)].val;
    }

    private void down(int rt) {
        if (arr[rt].lazy == 0) return;
        arr[ls(rt)].lazy += arr[rt].lazy;
        arr[rs(rt)].lazy += arr[rt].lazy;
        arr[rt].lazy = 0;
    }

    private void build(int rt, int l, int r) {
        if (l == r) {
            arr[rt].val = nums[l];
            arr[rt].l = l;
            arr[rt].r = r;
            return;
        }
        int mid = (l + r) >> 1;
        build(ls(rt), l, mid);
        build(rs(rt), mid + 1, r);
        up(rt);
        arr[rt].l = l;
        arr[rt].r = r;
    }

    // nowl, nowr指原数组中
    private int query(int rt, int ql, int qr) {
        if (ql <= arr[rt].l && qr >= arr[rt].r) return arr[rt].val + arr[rt].lazy * (arr[rt].r - arr[rt].l + 1);
        down(rt);
        int res = 0;
        int mid = (arr[rt].l + arr[rt].r) >> 1;
        if (ql <= mid) res += query(ls(rt), ql, qr);
        if (qr > mid) res += query(rs(rt), ql, qr);
        return res;
    }

    private void update(int rt, int ul, int ur, int val) {
        if (ul <= arr[rt].l && ur >= arr[rt].r) {
            if (arr[rt].l == arr[rt].r) arr[rt].val += val;
            else arr[rt].lazy += val;
            return;
        }
        int mid = (arr[rt].l + arr[rt].r) >> 1;
        if (ul <= mid) update(ls(rt), ul, ur, val);
        if (ur > mid) update(rs(rt), ul, ur, val);
        up(rt);
    }

    // buildTree
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        arr = new Node[n << 2];
        for(int i = 0; i < arr.length; i++) arr[i] = new Node();
        build(1, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(1, i, i, val);
    }

    public int sumRange(int i, int j) {
        return query(1, i, j);
    }
}

// LeetCode版本
//class NumArray {
//
//    class Node {
//        int l;
//        int r;
//        int val;
//        int lazy;
//        boolean tag;
//    }
//
//    private Node[] arr;
//    private int[] nums;
//    private int n;
//
//    private int ls(int i) {
//        return i << 1;
//    }
//
//    private int rs(int i) {
//        return i << 1 | 1;
//    }
//
//    private void up(int rt) {
//        arr[rt].val = arr[ls(rt)].val + arr[rs(rt)].val;
//    }
//
//    private void down(int rt) {
//        if (!arr[rt].tag) return;
//        arr[ls(rt)].lazy = arr[rt].lazy;
//        arr[rs(rt)].lazy = arr[rt].lazy;
//        arr[rt].tag = false;
//    }
//
//    private void build(int rt, int l, int r) {
//        if (l == r) {
//            arr[rt].val = nums[l];
//            arr[rt].l = l;
//            arr[rt].r = r;
//            return;
//        }
//        int mid = (l + r) >> 1;
//        build(ls(rt), l, mid);
//        build(rs(rt), mid + 1, r);
//        up(rt);
//        arr[rt].l = l;
//        arr[rt].r = r;
//    }
//
//    // nowl, nowr指原数组中
//    private int query(int rt, int ql, int qr) {
//        if (ql <= arr[rt].l && qr >= arr[rt].r) {
//            if(arr[rt].tag) return arr[rt].val + arr[rt].lazy * (arr[rt].r - arr[rt].l + 1);
//            return arr[rt].val;
//        }
//        down(rt);
//        int res = 0;
//        int mid = (arr[rt].l + arr[rt].r) >> 1;
//        if (ql <= mid) res += query(ls(rt), ql, qr);
//        if (qr > mid) res += query(rs(rt), ql, qr);
//        return res;
//    }
//
//    private void update(int rt, int ul, int ur, int val) {
//        if (ul <= arr[rt].l && ur >= arr[rt].r) {
//            if (arr[rt].l == arr[rt].r) arr[rt].val = val;
//            else arr[rt].lazy = val;
//            return;
//        }
//        int mid = (arr[rt].l + arr[rt].r) >> 1;
//        if (ul <= mid) update(ls(rt), ul, ur, val);
//        if (ur > mid) update(rs(rt), ul, ur, val);
//        up(rt);
//    }
//
//    // buildTree
//    public NumArray(int[] nums) {
//        n = nums.length;
//        this.nums = nums;
//        arr = new Node[n << 2];
//        for(int i = 0; i < arr.length; i++) arr[i] = new Node();
//        if(n != 0) build(1, 0, nums.length - 1);
//    }
//
//    public void update(int i, int val) {
//        update(1, i, i, val);
//    }
//
//    public int sumRange(int i, int j) {
//        return query(1, i, j);
//    }
//}
