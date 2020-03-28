package com.company.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P225 {
    class MyStack {

        /**
         * Initialize your data structure here.
         */
        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q.offer(x);
            for(int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
