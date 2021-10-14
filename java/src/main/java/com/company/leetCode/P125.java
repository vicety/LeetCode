package com.company.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String validSet = "abcdefghijklmnopqrstuvwxyz1234567890";
        Set<Character> set = new HashSet<>();
        for (Character c : validSet.toCharArray()) set.add(c);
        int pl = 0, pr = s.length() - 1;
        while (pl < pr) {
            while (pl < pr && !set.contains(s.charAt(pl))) pl++;
            while (pl < pr && !set.contains(s.charAt(pr))) pr--;
            if (s.charAt(pl) != s.charAt(pr)) return false;
            pl++;
            pr--;
        }
        return true;
    }
}
