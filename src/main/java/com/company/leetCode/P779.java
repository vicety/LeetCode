package com.company.leetCode;

import java.util.Stack;

public class P779 {
    public int kthGrammar(int N, int K) {
        Stack<Character> st = new Stack<>();
        N -= 1;
        K -= 1;
        while (N-- != 0) {
            int nxt = K / 2;
            if(nxt * 2 == K) st.add('l');
            else st.add('r');
            K = nxt;
        }
        int now = 0;
        while(!st.empty()) {
            char top = st.pop();
            if(top == 'r') now = now == 0 ? 1 : 0;
        }
        return now;
    }
}
