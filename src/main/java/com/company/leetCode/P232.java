package com.company.leetCode;

import java.util.Stack;

public class P232 {
    class MyQueue {

        Stack<Integer> queue = new Stack<>();
        Stack<Integer> tmp = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!queue.empty()) {
                tmp.push(queue.pop());
            }
            queue.push(x);
            while(!tmp.empty()) {
                queue.push(tmp.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return queue.pop();
        }

        /** Get the front element. */
        public int peek() {
            return queue.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
