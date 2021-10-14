package com.company.leetCode;

import java.util.*;

public class P1235 {
    class Order {
        int st, ed, profit;

        public Order(int st, int ed, int profit) {
            this.st = st;
            this.ed = ed;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime.length == 0) return 0;
        List<Order> orders = new ArrayList<>();
        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < startTime.length; i++) {
            indexes.add(startTime[i]);
            indexes.add(endTime[i]);
        }
        List<Integer> indexesArr = new ArrayList<>(indexes);
        indexesArr.sort(Comparator.comparingInt(i -> i));
        Map<Integer, Integer> toIndex = new HashMap<>();
        for (int i = 0; i < indexesArr.size(); i++) toIndex.put(indexesArr.get(i), i);
        for (int i = 0; i < startTime.length; i++) {
            orders.add(new Order(toIndex.get(startTime[i]), toIndex.get(endTime[i]), profit[i]));
        }
        orders.sort(Comparator.comparingInt(order -> order.st));
        int[] dp = new int[indexesArr.size()];
        List<List<Order>> schedule = new ArrayList<>();
        for (int i = 0; i < indexesArr.size(); i++) schedule.add(new ArrayList<>());
        for (Order order : orders) schedule.get(order.st).add(order);
        for (int i = indexesArr.size() - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            for (int j = 0; j < schedule.get(i).size(); j++) {
                Order order = schedule.get(i).get(j);
                dp[i] = Math.max(dp[i], dp[order.ed] + order.profit);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        System.out.println((Integer.MAX_VALUE - Integer.MIN_VALUE) / 2);
    }
}
