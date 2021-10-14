package com.company.leetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class P284 {
    class PeekingIterator implements Iterator<Integer> {

        Integer next = null;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if(next == null && iterator.hasNext()) next = iterator.next();
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (next != null) {
                int ret = next;
                next = null;
                return ret;
            } else return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return !(next == null && !iterator.hasNext());
        }
    }
}
