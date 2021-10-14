package com.company.leetCode;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class P382 {
    class Solution {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            while (head != null) {
                list.add(head.val);
            }
            head = head.next;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(0));
//        Collections.shuffle();
    }
}
