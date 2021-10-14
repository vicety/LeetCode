package com.company.leetCode;

import utils.ListNode;

public class P86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode lessNow = less, moreNow = more, now = head;
        while (now != null) {
            if(now.val >= x) {
                moreNow.next = now;
                moreNow = moreNow.next;
            } else {
                lessNow.next = now;
                lessNow = lessNow.next;
            }
            now = now.next;
        }
        lessNow.next = more.next;
        moreNow.next = null;
        return less.next;
    }
}
