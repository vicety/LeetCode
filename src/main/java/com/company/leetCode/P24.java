package com.company.leetCode;

import utils.ListNode;

// 1 2 3 4 5 6 7 8 9 10 11 -> 2 1 4 3 6 5 8 7 10 9 11
public class P24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head, second = head.next;
        ListNode ret = second;
        while(first != null && second != null) {
            ListNode nxtFirst = second.next;
            ListNode nxtSecond = null;
            if(nxtFirst != null) nxtSecond = nxtFirst.next;
            second.next = first;
            if(nxtSecond != null) first.next = nxtSecond;
            else first.next = nxtFirst;
            first = nxtFirst;
            second = nxtSecond;
        }
        return ret;
    }
}
