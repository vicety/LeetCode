package com.company.leetCode;

import utils.ListNode;

public class P142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == head) return head;
        ListNode fast = head;
        ListNode slow = head;
//        int cnt = 0;
        do {
            if(fast.next == null) return null;
            fast = fast.next;
            if(fast.next == null) return null;
            fast = fast.next;
            slow = slow.next;
//            cnt++;
        } while(slow != fast);
        ListNode another = head;
        while(slow != another) {
            slow = slow.next;
            another = another.next;
        }
        return slow;
    }
}
