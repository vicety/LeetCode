package com.company.leetCode;

import utils.ListNode;

public class P82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dumb = new ListNode(-1);
        if(head.val == -1) dumb.val = -2;
        dumb.next = head;
        ListNode now = dumb;
        ListNode nxt = now.next;
        while(nxt != null) {
            // 此时nxt必定为新数
            if(nxt.next == null) {
                now.next = nxt;
                break;
            } else if (nxt.val != nxt.next.val) {
                now.next = nxt;
                now = nxt;
                nxt = now.next;
            } else {
                while(nxt.next != null && nxt.val == nxt.next.val) nxt = nxt.next;
                if(nxt.next == null) {
                    now.next = null;
                    break;
                }
                else nxt = nxt.next;
            }
        }
        return dumb.next;
    }
}
