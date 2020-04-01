package com.company.leetCode;

import utils.ListNode;

public class P234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // in case that len(list) <= 2
        if (fast == slow) {
            if (slow.next == null) return true;
            else return slow.next.val == slow.val;
        }
        ListNode prev = head, after = slow.next;
        slow.next = null;
        // reverse prev
        ListNode next = head.next, tmp;
        prev.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        // for len(list) is odd
        if (fast.next == null) prev = prev.next;
        while (prev != null) {
            if (prev.val != after.val) return false;
            prev = prev.next;
            after = after.next;
        }
        return true;
    }
}
