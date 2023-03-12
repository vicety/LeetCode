#!/bin/python
# -*- coding: utf8 -*-
import sys
import os
import re


class ListNode:
    def __init__(self):
        self.data = None
        self.next = None


class Solution:
    def reverseBetween(self, head, left, right):
        # Write Code Here
        if left == right:
            return head

        dummy = ListNode()
        dummy.next = head
        now = 1
        now_node = dummy
        while now < left:
            now += 1
            now_node = now_node.next
        prev = now_node
        rev_end = now_node.next
        now_node = now_node.next
        nxt_node = now_node.next
        while left < right:
            left += 1
            nxt_nxt = nxt_node.next
            nxt_node.next = now_node
            now_node = nxt_node
            nxt_node = nxt_nxt
        rev_head = now_node
        after = nxt_node
        prev.next = rev_head
        rev_end.next = after
        return dummy.next


head_cnt = int(input())
dummy = ListNode()
now = dummy
for x in range(head_cnt):
    no = ListNode()
    no.data = int(input())
    now.next = no
    now = now.next

left = int(input())

right = int(input())

s = Solution()
res = s.reverseBetween(dummy.next, left, right)

while res != None:
    print(str(res.data) + " "),
    res = res.next
print("")
