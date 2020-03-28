package com.company.leetCode;

import java.util.Stack;

public class P168 {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        do {
            s.add((char) ('A' + --n % 26));
            n /= 26;
        } while (n != 0);
        while(!s.empty()) sb.append(s.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        P168 p168 = new P168();
        System.out.println(p168.convertToTitle(0));
    }
}
