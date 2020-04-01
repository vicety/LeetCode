package com.company.leetCode;

import utils.ListNode;

public class P206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head, now = head.next, next;
        head.next = null;
        while(now != null) {
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }
}
