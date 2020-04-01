package com.company.leetCode;

import com.company.leetCode.utils.Node;

public class P116_2 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node prev = root;
        Node next = root.left;
        while (next != null) {
            System.out.println("here");
            Node prevNow = prev;
            Node nextNow = next;
            while(true) {
                System.out.println(nextNow.val);
                nextNow.next = prev.right;
                nextNow = nextNow.next;
                if(prevNow.next == null) break;
                prevNow = prevNow.next;
                nextNow.next = prevNow.left;
                nextNow = nextNow.next;
            }
            prev = next;
            next = next.left;
        }
        return root;
    }
}
