package com.company.leetCode;

import utils.ListNode;

public class P141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast.next == null) return false;
            fast = fast.next;
            if(fast.next == null) return false;
            fast = fast.next;
            slow = slow.next;
        } while(slow != fast);
        return true;
    }
}
