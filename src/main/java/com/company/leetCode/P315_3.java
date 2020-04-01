package com.company.leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P315_3 {
    class Node {
        int val;
        int lazy;
        int l;
        int r;
    }

    Node[] tree;
    int[] nums;

    private int ls(int rt) {
        return rt << 1;
    }

    private int rs(int rt) {
        return rt << 1 | 1;
    }

    private void up(int rt) {
        tree[rt].val = tree[ls(rt)].val + tree[rs(rt)].val;
    }

    private void down(int rt) {
        if (tree[rt].lazy == 0) return;
        tree[ls(rt)].lazy += tree[rt].lazy;
        tree[ls(rt)].val += tree[rt].val * (tree[ls(rt)].r - tree[ls(rt)].l + 1);
        tree[rs(rt)].lazy += tree[rt].lazy;
        tree[rs(rt)].val += tree[rt].val * (tree[rs(rt)].r - tree[rs(rt)].l + 1);
        tree[rt].lazy = 0;
    }

    private void build(int[] arr, int now, int numl, int numr) {
        tree[now].l = numl;
        tree[now].r = numr;
        if (numl == numr) {
            tree[now].val = arr[numl];
            return;
        }
        int mid = (numl + numr) >> 1;
        build(arr, ls(now), numl, mid);
        build(arr, rs(now), mid + 1, numr);
        up(now);
    }

    private int query(int now, int ql, int qr) {
        if (ql <= tree[now].l && qr >= tree[now].r) return tree[now].val;
        down(now);
        int mid = (tree[now].l + tree[now].r) >> 1;
        int res = 0;
        if (qr > mid) res += query(rs(now), ql, qr);
        if (ql <= mid) res += query(ls(now), ql, qr);
        return res;
    }

    private void update(int now, int ul, int ur, int val) {
        if (ul <= tree[now].l && ur >= tree[now].r) {
            tree[now].lazy += val;
            tree[now].val += (tree[now].r - tree[now].l + 1) * val;
            return;
        }
        down(now);
        int mid = (tree[now].l + tree[now].r) >> 1;
        if (ur > mid) update(rs(now), ul, ur, val);
        if (ul <= mid) update(ls(now), ul, ur, val);
        up(now);
    }

    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        Map<Integer, Integer> numToIndex = new HashMap<>();
        tree = new Node[nums.length << 2];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        build(new int[nums.length], 1, 0, nums.length - 1);
        int[] ans = new int[nums.length];
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        for (int i = 0; i < sortedNums.length; i++) {
            numToIndex.put(sortedNums[i], i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if(numToIndex.get(nums[i]) == 0) {
                ans[i] = 0;
                update(1, numToIndex.get(nums[i]), numToIndex.get(nums[i]), 1);
                continue;
            }
            ans[i] = query(1, 0, numToIndex.get(nums[i]) - 1);
            update(1, numToIndex.get(nums[i]), numToIndex.get(nums[i]), 1);
        }
        return IntStream.of(ans).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        P315_3 p315_3 = new P315_3();
        System.out.println(p315_3.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
