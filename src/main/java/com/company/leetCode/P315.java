package com.company.leetCode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class P315 {

    class Node {
        int val;
        int weight;
        Node l;
        Node r;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    class BST {
        Node root;

        public Node insert(Node now, int val) {
            if (now == null) return new Node(val, 1);
            now.weight++;
            if (val == now.val) return now;
            else if (val < now.val) now.l = insert(now.l, val);
            else now.r = insert(now.r, val);
            return now;
        }

        public int query(Node now, int val) {
            if (now == null) return 0;
            int res = 0;
            if (val < now.val) res += query(now.l, val);
            else if (val == now.val) {
                if (now.l != null) res += now.l.weight;
            } else {
                res += now.weight;
                if (now.r != null) res -= now.r.weight;
                res += query(now.r, val);
            }
            return res;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length];
        BST bst = new BST();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = bst.query(bst.root, nums[i]);
            bst.root = bst.insert(bst.root, nums[i]);
        }
        return IntStream.of(ans).boxed().collect(Collectors.toList());
    }
}
