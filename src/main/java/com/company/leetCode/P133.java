package com.company.leetCode;

import java.util.*;

public class P133 {
    // Definition for a Node.
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node dfs(Node origin, Map<Integer, Node> vis) {
        if(vis.containsKey(origin.val)) return vis.get(origin.val);
        Node ret = new Node(origin.val);
        vis.put(origin.val, ret);
        for (Node next : origin.neighbors) {
            ret.neighbors.add(dfs(next, vis));
        }
        return ret;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }
}