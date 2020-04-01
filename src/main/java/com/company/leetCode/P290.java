package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        if (pattern.length() != strs.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(c2s.get(c) != null && !c2s.get(c).equals(strs[i])) return false;
            if(s2c.get(strs[i]) != null && s2c.get(strs[i]) != c) return false;
            if(c2s.get(c) != null) continue;
            c2s.put(c, strs[i]);
            s2c.put(strs[i], c);
        }
        return true;
    }
}
