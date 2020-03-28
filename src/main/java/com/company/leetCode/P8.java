package com.company.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class P8 {

    private int attriI;

    private volatile boolean arrtiB;

    public int myAtoi(String str) {
        int minus = 1;
        str = str.trim();
        if(str.isEmpty()) return 0;
        System.out.println(str);
        List<Character> arr = new ArrayList<>();
//        str = str.split(" ")[0];
        Set<Character> st = "0123456789".chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
        int ans = 0;
        if (str.charAt(0) == '-') {
            minus = -1;
            if(str.length() == 1) return 0;
            str = str.substring(1);
        }
        else if (str.charAt(0) == '+') {
            minus = 1;
            if(str.length() == 1) return 0;
            str = str.substring(1);
        }
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (st.contains(str.charAt(i))) end++;
            else break;
        }
        str = str.substring(0, end);
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) == '-' || str.charAt(i) == '+') return 0;
        if (str.isEmpty()) return 0;
        for (char ch : str.toCharArray()) {
            int num = ch - '0';
            if (ans * minus <= (Integer.MAX_VALUE - num) / 10 && ans * minus >= (Integer.MIN_VALUE + num) / 10)
                ans = ans * 10 + num;
            else if (ans * minus > (Integer.MAX_VALUE - num) / 10) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        return ans * minus;
    }

    public static void main(String[] args) {
        P8 p8 = new P8();
        System.out.println(p8.myAtoi("   - "));
//        System.out.println("asbc".substring(0,0));
    }
}
