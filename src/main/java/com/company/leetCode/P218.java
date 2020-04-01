package com.company.leetCode;

import java.util.*;

public class P218 {
    private class Node {
        Node ls, rs;
        int l, r, val, lazy;

        public Node(Node ls, Node rs, int l, int r, int val, int lazy) {
            this.ls = ls;
            this.rs = rs;
            this.l = l;
            this.r = r;
            this.val = val;
            this.lazy = lazy;
        }
    }

    private void pushUp(Node now) {
        now.val = Math.max(now.ls.val, now.rs.val);
    }

    private void pushDown(Node now) {
        now.ls.val = Math.max(now.ls.val, now.lazy);
        now.ls.lazy = Math.max(now.ls.lazy, now.lazy);
        now.rs.val = Math.max(now.rs.val, now.lazy);
        now.rs.lazy = Math.max(now.rs.lazy, now.lazy);
        now.lazy = 0;
    }

    private Node buildTree(int l, int r, List<Node> nodes) {
        if (l == r) {
            Node ret = new Node(null, null, l, r, 0, 0);
            nodes.add(ret);
            return ret;
        }
        int mid = l + (r - l) / 2;
        Node ret = new Node(null, null, l, r, 0, 0);
        ret.ls = buildTree(l, mid, nodes);
        ret.rs = buildTree(mid + 1, r, nodes);
        pushUp(ret);
        return ret;
    }

    private void rangeUpdate(int ul, int ur, Node now, int update) {
        if (now.l >= ul && now.r <= ur) {
            now.val = Math.max(now.val, update);
            now.lazy = Math.max(now.lazy, update);
            return;
        }
        pushDown(now);
        int mid = now.l + (now.r - now.l) / 2;
        if (ul <= mid) rangeUpdate(ul, ur, now.ls, update);
        if (ur > mid) rangeUpdate(ul, ur, now.rs, update);
        pushUp(now);
    }

    private int rangeQuery(int ql, int qr, Node now) {
        if (ql <= now.l && qr >= now.r) return now.val;
        int mid = now.l + (now.r - now.l) / 2;
        pushDown(now);
        int ans = Integer.MIN_VALUE;
        if (ql <= mid) ans = Math.max(ans, rangeQuery(ql, qr, now.ls));
        if (qr > mid) ans = Math.max(ans, rangeQuery(ql, qr, now.rs));
        return ans;
    }

    // [l, r, h] -> [index, h]
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings.length == 0) return new ArrayList<>();
        Map<Integer, Integer> toDiscrete = new HashMap<>();
        Set<Integer> locations = new HashSet<>();
        for (int[] building : buildings) {
            locations.add(building[0]);
            locations.add(building[1]);
        }
        List<Integer> toRealLocation = new ArrayList<>(locations);
        toRealLocation.sort(Comparator.comparingInt(Integer::intValue));
        for (int i = 0; i < toRealLocation.size(); i++) {
            toDiscrete.put(toRealLocation.get(i), i);
        }
        List<Node> nodes = new ArrayList<>();
        Node root = buildTree(0, toRealLocation.size() - 2, nodes);
        for (int[] building : buildings) {
            int l = building[0], r = building[1], h = building[2];
            int disL = toDiscrete.get(l), disR = toDiscrete.get(r);
            rangeUpdate(disL, disR - 1, root, h);
        }
        List<Integer> ansWithRedundancy = new ArrayList<>();
        for (int i = 0; i <= toRealLocation.size() - 2; i++) {
            ansWithRedundancy.add(rangeQuery(i, i, root));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < ansWithRedundancy.size(); i++) {
            int h = ansWithRedundancy.get(i);
            if (ans.isEmpty()) {
                List<Integer> one = new ArrayList<>();
                one.add(toRealLocation.get(i));
                one.add(h);
                ans.add(one);
            } else {
                if (ans.get(ans.size() - 1).get(1) != h) {
                    List<Integer> one = new ArrayList<>();
                    one.add(toRealLocation.get(i));
                    one.add(h);
                    ans.add(one);
                }
            }
        }
        List<Integer> last = new ArrayList<>();
        last.add(toRealLocation.get(toRealLocation.size() - 1));
        last.add(0);
        ans.add(last);
        return ans;
    }

    public static void main(String[] args) {
        P218 p218 = new P218();
        int[][] buildings = new int[][]{
                new int[]{2, 9, 10}, new int[]{3, 7, 15},
                new int[]{5, 12, 12}, new int[]{15, 20, 10}, new int[]{19, 24, 8}
        };
        System.out.println(p218.getSkyline(buildings));
        buildings = new int[][]{
                new int[]{2, 9, 10}
        };
        System.out.println(p218.getSkyline(buildings));
    }
}
