package com.company.practiceNewFeature;

import java.util.*;

public class TreeMapIterate {
    public static void main(String[] args) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        Random ran = new Random();
        for (int i = 0; i < 2000; i++) {
            int next = ran.nextInt(400);
            mp.put(next, mp.getOrDefault(next, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(String.format("%d %d", entry.getKey(), entry.getValue()));
        }
    }
}
