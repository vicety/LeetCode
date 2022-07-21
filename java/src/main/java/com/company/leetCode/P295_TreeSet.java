package com.company.leetCode;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class P295_TreeSet {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        medianFinder.addNum(10);
        medianFinder.addNum(2);
        medianFinder.addNum(6);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {
        class Pair {
            Integer val;
            int idx;

            public Pair(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }
        }

        private Comparator<Pair> cp = (a, b) -> {
            if (!Objects.equals(a.val, b.val)) return Integer.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        };
        private TreeSet<Pair> lo = new TreeSet<>(cp);
        private TreeSet<Pair> hi = new TreeSet<>(cp);
        private int idx = 0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            hi.add(new Pair(num, idx++));
            lo.add(hi.pollFirst());
            if (lo.size() > hi.size()) hi.add(lo.pollLast());
        }

        public double findMedian() {
            if (lo.size() == hi.size()) return (lo.last().val.doubleValue() + hi.first().val) / 2;
            return hi.first().val;
        }
    }

}
