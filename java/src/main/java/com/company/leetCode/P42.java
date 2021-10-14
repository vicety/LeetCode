package com.company.leetCode;

import java.util.Stack;

public class P42 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        int leftMax = Integer.MIN_VALUE;
        st.push(0);
        for (int i = 1; i < height.length; i++) {
            if(height[i] < st.peek()) st.push(i);
            if(height[i] > st.peek()) {
                while (st.size() > 1 && height[i] > st.peek()) {
                    
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P42 p42 = new P42();
        System.out.println(p42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
