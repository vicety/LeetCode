package com.company.leetCode;

import java.util.Stack;

public class P67 {
    private int b2i(String b) {
        int weight = 1;
        int ans = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '1') ans += weight;
            weight *= 2;
        }
        return ans;
    }

    private String i2b(int i) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        while (i > 0) {
            if (i % 2 == 1) {
                st.add('1');
            } else st.add('0');
            i >>= 1;
        }
        while(!st.empty()) sb.append(st.pop());
        return sb.toString();
    }

    public String addBinary(String a, String b) {
        int ia = b2i(a);
        int ib = b2i(b);
        int sum = ia + ib;
        if(sum == 0) return "0";
        return i2b(sum);
    }
}
