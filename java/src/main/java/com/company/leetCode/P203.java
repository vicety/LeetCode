package com.company.leetCode;

import utils.ListNode;

public class P203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode now = dumb;
        while (now != null) {
            while (now.next != null && now.next.val == val) now.next = now.next.next;
            now = now.next;
        }
        return dumb.next;
    }
}
