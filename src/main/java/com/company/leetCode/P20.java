package com.company.leetCode;

import java.util.*;

public class P20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> stIn = new HashSet<>();
        stIn.add('(');
        stIn.add('{');
        stIn.add('[');
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(stIn.contains(s.charAt(i))) st.push(s.charAt(i));
            else {
                if(st.isEmpty()) return false;
                if(s.charAt(i) == ')' && st.peek() == '('
                || s.charAt(i) == ']' && st.peek() == '['
                || s.charAt(i) == '}' && st.peek() == '{')
                    st.pop();
                else return false;
            }
        }
        return st.empty();
    }
}
