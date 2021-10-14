package com.company.leetCode;

import utils.ListNode;

public class P143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) break;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode reverseHead = slow.next;
        slow.next = null;
        ListNode prev = reverseHead, now = reverseHead.next, next;
        reverseHead.next = null;
        while (now != null) {
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        ListNode afterHead = prev;
        ListNode prevHead = head;
        ListNode prevTmp, afterTmp;
        while (prevHead != null && afterHead != null) {
            prevTmp = prevHead.next;
            afterTmp = afterHead.next;
            afterHead.next = prevHead.next;
            prevHead.next = afterHead;
            prevHead = prevTmp;
            afterHead = afterTmp;
        }
    }
}
