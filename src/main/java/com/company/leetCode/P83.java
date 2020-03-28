package com.company.leetCode;

import utils.ListNode;

public class P83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode now = head;
        while(true) {
            while(now.next != null && now.next.val == now.val) now.next = now.next.next;
            if(now.next == null) break;
            now = now.next;
        }
        return head;
    }
}
