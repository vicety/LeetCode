package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P84 {
    public int largestRectangleArea(int[] heights) {
        List<Integer> h = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i]);
            for (int j = 0; j < h.size(); j++) {
                ans = Math.max(ans, Math.min(heights[i], h.get(j)) * (i - index.get(j) + 1));
            }
            while(!h.isEmpty() && heights[i] < h.get(h.size() - 1)) {
                h.remove(h.size() - 1);
                index.remove(index.size() - 1);
            }
            h.add(heights[i]);
            index.add(i);
        }
        return ans;
    }
}
