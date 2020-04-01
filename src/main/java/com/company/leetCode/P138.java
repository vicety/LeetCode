package com.company.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P138 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Node copy(Node now, Map<Node, Node> vis) {
        if(now == null) return null;
        if(vis.containsKey(now)) return vis.get(now);
        Node ret = new Node(now.val);
        vis.put(now, ret);
        ret.next = copy(now.next, vis);
        ret.random = copy(now.random, vis);
        return ret;
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        return copy(head, new HashMap<>());
    }
}
