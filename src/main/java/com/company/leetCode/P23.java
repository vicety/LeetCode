package com.company.leetCode;

import org.w3c.dom.NodeList;
//import utils.ListNode;
//import utils.MaxHeap;

import java.util.*;
import java.util.stream.Collectors;

public class P23 {

//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length == 0) return null;
//        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(11, Comparator.comparingInt((ListNode a) -> a.val));
//        ListNode dumb = new ListNode(-1);
//        ListNode now = dumb;
//        List<ListNode> listNotEmpty = Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList());
//        priorityQueue.addAll(listNotEmpty);
//        while(!priorityQueue.isEmpty()) {
//            ListNode top = priorityQueue.remove();
//            now.next = new ListNode(top.val);
//            now = now.next;
//            if(top.next != null) priorityQueue.offer(top.next);
//        }
//        return dumb.next;
//    }
}
