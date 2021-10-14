package com.company.leetCode;

public class P58 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().equals("")) return 0;
        String[] split = s.trim().split(" ");
        return split[split.length - 1].length();
    }
}
