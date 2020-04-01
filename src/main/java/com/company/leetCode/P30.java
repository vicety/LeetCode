package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) return new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (String word : words) {
            mp.computeIfPresent(word, (k, v) -> v + 1);
            mp.putIfAbsent(word, 1);
        }
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int windowSize = wordLen * words.length;
        for (int i = 0; i < s.length() - windowSize + 1; i++) {
            String chunk = s.substring(i, i + windowSize);
            System.out.println(chunk);
            for (int j = 0; j < windowSize; j += wordLen) {
                String word = chunk.substring(j, j + wordLen);
                System.out.println(" " + word);
                if(mp.get(word) != null) mp.put(word, mp.get(word) - 1);
                else break;
            }
            boolean success = true;
            for (String word : words) {
                if(mp.get(word) != 0) success = false;
                mp.put(word, 0);
            }
            if(success) ans.add(i);
            for (String word : words) {
                mp.put(word, mp.get(word) + 1);
            }
        }
        return ans;
    }
}
