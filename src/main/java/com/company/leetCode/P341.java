package com.company.leetCode;

import java.util.*;

public class P341 {
    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private Stack<Iterator<NestedInteger>> iterators = new Stack<>();
        Integer cache = null;
        Boolean lastResult = null; // 上次hasNext的结果

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList == null) return;
            iterators.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            hasNext(); // if false throw Exception
            lastResult = null;
            return cache;
        }

        @Override
        public boolean hasNext() {
            if(lastResult != null) return lastResult;
            while (!iterators.isEmpty() && !iterators.peek().hasNext()) iterators.pop();
            if(iterators.isEmpty()) {
                lastResult = false;
                return false;
            }
            NestedInteger next = iterators.peek().next();
            if (next.isInteger()) {
                cache = next.getInteger();
                lastResult = true;
                return true;
            } else {
                iterators.push(next.getList().iterator());
                return hasNext();
            }
        }
    }

//    public class NestedIterator implements Iterator<Integer> {
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            lists = new Stack<>();
//            lists.push(nestedList.listIterator());
//        }
//
//        public Integer next() {
//            hasNext();
//            return lists.peek().next().getInteger();
//        }
//
//        public boolean hasNext() {
//            while (!lists.empty()) {
//                if (!lists.peek().hasNext()) {
//                    lists.pop();
//                } else {
//                    NestedInteger x = lists.peek().next();
//                    if (x.isInteger())
//                        return lists.peek().previous() == x;
//                    lists.push(x.getList().listIterator());
//                }
//            }
//            return false;
//        }
//
//        private Stack<ListIterator<NestedInteger>> lists;
//    }

    public static void main(String[] args) {
        System.out.println((new ArrayList<>()).iterator().hasNext());
    }
}
