package com.company.leetCode;

import java.util.Stack;

public class P387 {
    public int firstUniqChar(String s) {
        int[] vis = new int[26];
        int[] index = new int[26];
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int hash = c - 'a';
            if (vis[hash] == 0) {
                stack.add(c);
                index[hash] = i;
            }
            vis[hash]++;
        }
        while (!stack.isEmpty()) {
            if (vis[stack.peek() - 'a'] == 1) return index[stack.peek() - 'a'];
            stack.pop();
        }
        return -1;
    }
}
