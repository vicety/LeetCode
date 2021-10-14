package com.company.leetCode;

import java.util.List;
import java.util.Stack;

public class P385 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 1;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

    class Solution {
        public NestedInteger deserialize(String s) {
            Integer num = null;
            Boolean minus = false;
            Stack<NestedInteger> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.add(new NestedInteger());
                } else if(c == ']') {
                    // flush number into list
                    if(num != null) {
                        NestedInteger nestedInt = new NestedInteger(num * (minus ? -1 : 1));
                        stack.peek().add(nestedInt);
                        minus = false;
                        num = null;
                    }
                    NestedInteger top = stack.pop();
                    if(stack.isEmpty()) return top;
                    stack.peek().add(top);
                } else if(c == ',') {
                    if(num != null) {
                        // must be in list, stack must not empty
                        stack.peek().add(new NestedInteger(num * (minus ? -1 : 1)));
                        minus = false;
                        num = null;
                    }
                } else if( c== '-') {
                    minus = true;
                } else {
                    if(num == null) num = (c - '0');
                    else num = num * 10 + (c - '0');
                }
            }
            if(num != null) return new NestedInteger(num * (minus ? -1 : 1));
            return stack.peek();
        }
    }
}
