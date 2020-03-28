package com.company.leetCode;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

import utils.ListNode;

public class P19 {

}

// 快慢指针 assume n <= length of list
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // add a dumb node
        ListNode newList = new ListNode(-1);
        newList.next = head;
        ListNode fast = head;
        for(int i = 0; i < n - 1; i++) fast = fast.next;
        ListNode slow = newList;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newList.next;
    }
}
