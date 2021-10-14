package com.company.leetCode;

public class P318 {
    private int toInt(String word) {
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans |= (1 << (word.charAt(i) - 'a'));
        }
        return ans;
    }

    public int maxProduct(String[] words) {
        int[] chars = new int[words.length];
        for (int i = 0; i < words.length; i++) chars[i] = toInt(words[i]);
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((chars[i] & chars[j]) != 0) continue;
                ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
