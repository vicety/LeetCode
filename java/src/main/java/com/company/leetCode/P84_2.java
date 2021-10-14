package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P84_2 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        List<Integer> list = IntStream.of(heights).boxed().collect(Collectors.toList());
        list.add(0);
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            while(!st.empty() && list.get(st.peek()) > list.get(i)) {
                int base = st.pop();
                if(st.empty()) ans = Math.max(ans, list.get(base));
                else ans = Math.max(ans, list.get(base) * (i - base));
            }
            if(st.empty() || list.get(i) != st.peek()) st.add(i);
        }
        return ans;
    }
}
