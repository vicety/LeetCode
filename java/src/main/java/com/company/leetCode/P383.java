package com.company.leetCode;

public class P383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) if (cnt[i] < 0) return false;
        return true;
    }
}
