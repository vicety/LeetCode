package com.company.leetCode;

import java.util.Stack;

public class P67_2 {
    public String addBinary(String a, String b) {
        Stack<Character> st = new Stack<>();
        int inc = 0;
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        while (pa >= 0 && pb >= 0) {
            int sum = (int) a.charAt(pa) + (int) b.charAt(pb) - '0' * 2 + inc;
            st.add(sum % 2 == 1 ? '1' : '0');
            inc = sum / 2;
            pa--;
            pb--;
        }
        while (pa >= 0) {
            int sum = (int) a.charAt(pa) - '0' + inc;
            st.add(sum % 2 == 1 ? '1' : '0');
            inc = sum / 2;
            pa--;
        }
        while (pb >= 0) {
            int sum = (int) b.charAt(pb) - '0' + inc;
            st.add(sum % 2 == 1 ? '1' : '0');
            inc = sum / 2;
            pb--;
        }
        if(inc == 1) st.add('1');
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) sb.append(st.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(Integer.valueOf('9'));
//        System.out.println("10");
    }
}
