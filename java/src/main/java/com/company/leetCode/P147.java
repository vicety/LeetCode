package com.company.leetCode;

import utils.ListNode;

public class P147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dumb = new ListNode(-1);
        ListNode newListPtr = dumb;
        ListNode now = head;
        ListNode next;
        while (now != null) {
            next = now.next;
            while (newListPtr.next != null && now.val > newListPtr.next.val) {
                newListPtr = newListPtr.next;
            }
            now.next = newListPtr.next;
            newListPtr.next = now;
            newListPtr = dumb;
            now = next;
        }
        return dumb.next;
    }
}
