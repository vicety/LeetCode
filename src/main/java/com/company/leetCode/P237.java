package com.company.leetCode;

import utils.ListNode;

public class P237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
