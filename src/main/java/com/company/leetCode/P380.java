package main.java.com.company.leetCode;

import java.util.*;

public class P380 {
    class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> toIndex = new HashMap<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (toIndex.containsKey(val)) return false;
            if (toIndex.size() == list.size()) list.add(val);
            else list.set(toIndex.size(), val);
            toIndex.put(val, toIndex.size());
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!toIndex.containsKey(val)) return false;
            int index = toIndex.get(val);
            list.set(index, list.get(toIndex.size() - 1));
            toIndex.put(list.get(index), index);
            toIndex.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(toIndex.size()));
        }
    }
}
