package com.company.leetCode;

import utils.ListNode;

public class P21 {
}



class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumb = new ListNode(-1);
        ListNode now = dumb;
        dumb.next = l1;
        ListNode head = l2;
        while(now.next != null && head != null) {
            if(now.next.val < head.val) now = now.next;
            else {
                ListNode insertNode = new ListNode(head.val);
                insertNode.next = now.next;
                now.next = insertNode;
                now = now.next;
                head = head.next;
            }
        }
        if(head != null) now.next = head;
        return dumb.next;
    }
}