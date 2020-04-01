package com.company.leetCode;

import utils.ListNode;

public class P328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode odd = head, even = head.next;
        while (even != null && even.next != null) {
            ListNode oddNext = even.next;
            ListNode evenNext = even.next.next;
            odd.next = oddNext;
            even.next = evenNext;
            odd = oddNext;
            even = evenNext;
        }
        odd.next = evenHead;
        return oddHead;
    }
}
