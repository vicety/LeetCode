package com.company.leetCode;

import java.util.*;

public class P187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        if (s.length() < 10) return ans;
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(mp.containsKey(sub) && mp.get(sub) == 1) ans.add(sub);
            mp.put(sub, mp.getOrDefault(sub, 0) + 1);
        }
        return ans;
    }
}
