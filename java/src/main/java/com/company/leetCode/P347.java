package com.company.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class P347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (pq.size() < k) pq.offer(Arrays.asList(map.get(key), key));
            else if (map.get(key) > pq.peek().get(0)) {
                pq.poll();
                pq.offer(Arrays.asList(map.get(key), key));
            }
        }
        return pq.stream().map(i -> i.get(1)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        P347 p347 = new P347();
        System.out.println(p347.topKFrequent(new int[]{
                3, 0, 1, 0}, 1));
//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(1);
//        pq.add(2);
//        pq.add(3);
//        while(!pq.isEmpty()) System.out.println(pq.poll());

    }
}
