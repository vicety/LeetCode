package com.company.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P295 {
    class MedianFinder {

        private Queue<Integer> lheap = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        private Queue<Integer> rheap = new PriorityQueue<>(Comparator.comparingInt(i -> i));

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (lheap.isEmpty()) {
                lheap.add(num);
                return;
            }
            if (lheap.size() == rheap.size()) {
                int l = lheap.peek(), r = rheap.peek();
                if(num <= r) lheap.add(num);
                else {
                    lheap.add(rheap.poll());
                    rheap.add(num);
                }
            }
            else {
                int l = lheap.peek();
                if(num >= l) rheap.add(num);
                else {
                    rheap.add(lheap.poll());
                    lheap.add(num);
                }
            }
        }

        public double findMedian() {
            if (lheap.size() != rheap.size()) return lheap.peek();
            else return ((double) lheap.peek() + rheap.peek()) / 2;
        }
    }

}
