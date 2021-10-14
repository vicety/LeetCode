package com.company.leetCode;

import java.util.*;

public class P327_4 {
    class Node {
        Node ls, rs;
        int l, r, val;

        public Node(Node ls, Node rs, int l, int r, int val) {
            this.ls = ls;
            this.rs = rs;
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }

    private void pushUp(Node node) {
        node.val = node.ls.val + node.rs.val;
    }

    private Node buildTree(int[] arr, int l, int r) {
        if (l == r) {
            return new Node(null, null, l, r, arr[l]);
        }
        Node ret = new Node(null, null, l, r, 0);
        int mid = l + (r - l) / 2;
        ret.ls = buildTree(arr, l, mid);
        ret.rs = buildTree(arr, mid + 1, r);
        pushUp(ret);
        return ret;
    }

    private void update(int index, Node now) {
        if (now.l == now.r) {
            now.val++;
            return;
        }
        if (now.ls.r >= index) update(index, now.ls);
        else update(index, now.rs);
        pushUp(now);
    }

    private int query(int ql, int qr, Node now) {
        if (now.l >= ql && now.r <= qr) return now.val;
        int mid = now.l + (now.r - now.l) / 2;
        int ans = 0;
        if (ql <= mid) ans += query(ql, qr, now.ls);
        if (qr > mid) ans += query(ql, qr, now.rs);
        return ans;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) prefix[i] = prefix[i - 1] + nums[i - 1];
        Set<Long> indexes = new HashSet<>();
        for (long num : prefix) {
            indexes.add(num);
            indexes.add(num - lower);
            indexes.add(num - upper);
        }
        Long[] indexesWithoutDuplication = indexes.toArray(new Long[0]);
        Arrays.sort(indexesWithoutDuplication);
        Map<Long, Integer> toIndex = new HashMap<>();
        for (int i = 0; i < indexesWithoutDuplication.length; i++) toIndex.put(indexesWithoutDuplication[i], i);
        Node root = buildTree(new int[indexesWithoutDuplication.length],
                0, indexesWithoutDuplication.length - 1);
        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            ans += query(toIndex.get(prefix[i] - upper), toIndex.get(prefix[i] - lower), root);
            update(toIndex.get(prefix[i]), root);
        }
        return ans;
    }

    public static void main(String[] args) {
        P327_4 p327_4 = new P327_4();
        System.out.println(p327_4.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
