package com.company.leetCode;

import com.company.leetCode.utils.Node;

public class P117 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node prev = root;
        Node next = null;
        Node prevNow = null;
        Node nextNow = null;
        while (true) {
            while (prev != null) {
                if (prev.left != null) {
                    next = prev.left;
                    break;
                } else if (prev.right != null) {
                    next = prev.right;
                    break;
                }
                prev = prev.next;
            }
            if (next == null) break;
            prevNow = prev;
            nextNow = next;
            while (prevNow != null) {
                if(prevNow.left != null && prevNow.left != nextNow) {
                    nextNow.next = prevNow.left;
                    nextNow = nextNow.next;
                }
                if(prevNow.right != null && prevNow.right != nextNow) {
                    nextNow.next = prevNow.right;
                    nextNow = nextNow.next;
                }
                prevNow = prevNow.next;
            }
            prev = next;
            next = null;
        }
        return root;
    }
}
