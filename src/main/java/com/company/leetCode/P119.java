package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cache = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        cache.add(1);
        if (rowIndex == 0) return cache;
        for (int i = 1; i <= rowIndex; i++) {
            now.add(1);
            for (int j = 0; j < i - 1; j++) now.add(cache.get(j) + cache.get(j + 1));
            now.add(1);
            cache = now;
            now = new ArrayList<>();
        }
        return cache;
    }
}
