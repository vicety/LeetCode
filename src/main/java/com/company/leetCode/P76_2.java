package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P76_2 {
    public String minWindow(String s, String t) {
        int l = 0;
        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : t.toCharArray()) mp.put(c, mp.getOrDefault(c, 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) - 1);
            if (mp.get(c) >= 0) cnt++;
            while (cnt == t.length()) {
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    ans = s.substring(l, i + 1);
                }
                char cl = s.charAt(l);
                mp.put(cl, mp.getOrDefault(cl, 0) + 1);
                if (mp.get(cl) > 0) cnt--;
                l++;
            }
        }
        return ans;
    }
}
