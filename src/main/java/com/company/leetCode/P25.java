package com.company.leetCode;

import utils.ListNode;

public class P25 {

        // 确保head不为空，传入下一段的第一个节点
        private ListNode hasNextK(ListNode head, int k) {
            while(head != null && k-- != 0) {
                if(k == 0) return head;
                head = head.next;
            }
            return null;
        }

        // 返回翻转区间的第一个节点，也就是原区间的最后一个节点（确保有k个节点, k >= 2）
        // 输入的是区间的第一个节点
        private ListNode reverseK(ListNode head, int k) {
            ListNode prev, nxt, tmp;
            prev = head;
            nxt = head.next;
            while(nxt != null && k-- != 1) {
                tmp = nxt.next;
                nxt.next = prev;
                prev = nxt;
                nxt = tmp;
            }
            return prev;
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if(k == 1) return head;
            ListNode dumb = new ListNode(-1);
            dumb.next = head;
            ListNode now = dumb;
            ListNode nxtFirst, nxtLast, nxtnxt;
            while (hasNextK(now.next, k) != null) {
                nxtLast = now.next;

                nxtnxt = nxtLast;
                for(int i = 0; i < k; i++) {
                    nxtnxt = nxtnxt.next;
                }

                nxtFirst = reverseK(now.next, k);
                now.next = nxtFirst;
                now = nxtLast;
                now.next = nxtnxt;
            }
            return dumb.next;
        }

        private static ListNode buildList(int[] arr) {
            ListNode dumb = new ListNode(-1);
            ListNode now = dumb;
            for(int item : arr) {
                now.next = new ListNode(item);
                now = now.next;
            }
            return dumb.next;
        }

    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5, 6, 7});
        P25 p25 = new P25();
        p25.reverseKGroup(head, 6);
    }
}