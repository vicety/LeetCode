package com.company.leetCode;

import utils.ListNode;

public class P61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode now = head;
        int len = 0;
        while(now != null) {
            len++;
            now = now.next;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode front = head;
        int tmp = k;
        while(tmp-- != 0) front = front.next;
        ListNode back = head;
        while(front.next != null) {
            front = front.next;
            back = back.next;
        }
        ListNode newHead = back.next;
        front.next = head;
        back.next = null;
        return newHead;
    }
}
