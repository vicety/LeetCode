package main.java.com.company.leetCode;

import javax.print.event.PrintEvent;
import java.util.*;

public class P381 {
    class RandomizedCollection {

        private Map<Integer, List<Integer>> toIndex = new HashMap<>();
        private Map<Integer, Integer> indexToIndex = new HashMap<>();
        private List<Integer> list = new ArrayList<>();
        private Random random = new Random();
        int size;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean notContains = !toIndex.containsKey(val);
            if (notContains) toIndex.put(val, new ArrayList<>());
            toIndex.get(val).add(size);
            if (size == list.size()) list.add(val);
            else list.set(size, val);
            indexToIndex.put(size, toIndex.get(val).size() - 1);
            size++;
            return notContains;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!toIndex.containsKey(val)) return false;
            List<Integer> removeList = toIndex.get(val);
            int index = removeList.get(removeList.size() - 1);
            removeList.remove(removeList.size() - 1);
//            indexToIndex.remove(index);
            if(index  != size - 1) {
                int fill = list.get(size - 1);
                list.set(index, fill);
                toIndex.get(fill).set(indexToIndex.get(size - 1), index);
                indexToIndex.put(index, indexToIndex.get(size - 1));
            }
            indexToIndex.remove(size - 1);
            if(toIndex.get(val).size() == 0) toIndex.remove(val);
            size--;
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(random.nextInt(size));
        }
    }

    public static void main(String[] args) {
        P381 p381= new P381();
        RandomizedCollection randomizedCollection = p381.new RandomizedCollection();
        randomizedCollection.insert(0);
        randomizedCollection.remove(0);
        randomizedCollection.insert(-1);
        randomizedCollection.remove(0);
    }
}
