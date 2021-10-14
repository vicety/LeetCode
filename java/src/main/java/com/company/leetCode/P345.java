package com.company.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int st = 0, ed = s.length() - 1;
        char tmp;
        char[] chars = s.toCharArray();
        while (st < ed) {
            while (st < ed && !set.contains(chars[st])) st++;
            while (ed > st && !set.contains(chars[ed])) ed--;
            tmp = chars[st];
            chars[st] = chars[ed];
            chars[ed] = tmp;
            st++;
            ed--;
        }
        return new String(chars);
    }
}
