package com.company.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    Queue<Node> q;
    List<List<Node>> ls = new ArrayList<>();

    private void solve(Node now, int depth) {
        if(now == null) return;
        if(ls.size() < depth) ls.add(new ArrayList<>());
        ls.get(depth - 1).add(now);
        solve(now.left, depth + 1);
        solve(now.right, depth + 1);
    }

    public Node connect(Node root) {
        q = new LinkedList<>();
        solve(root, 1);
        for(int i = 0; i < ls.size(); i++) {
            for(int j = 0; j < ls.get(i).size(); j++) {
                if(j != ls.get(i).size() - 1) ls.get(i).get(j).next = ls.get(i).get(j + 1);
            }
        }
        return root;
    }
}
