package com.company.leetCode;

import utils.ListNode;

public class P92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode prev = dumb, now, nxt;
        for(int i = 0; i < m - 1; i++) prev = prev.next;
        now = prev.next;
        nxt = now.next;
        for(int i = m; i < n; i++) {
            now.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
            nxt = now.next;
        }
        return dumb.next;
    }
}
