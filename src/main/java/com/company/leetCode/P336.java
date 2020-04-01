package com.company.leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> toIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            toIndex.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            Integer another;
            if (str.length() == 0) continue; // prefix == suffix, may create duplicate
            for (int j = 0; j <= str.length(); j++) {
                String prefix = str.substring(0, j);
                String suffix = str.substring(j);
                if (isPalindrome(prefix)) {
                    another = toIndex.get(reverse(suffix));
                    if (another != null && another != i)
                        ans.add(Arrays.asList(another, i));
                }
                // str + str.reverse only happens at str.reverse when prefix = ""
                if (suffix.length() != 0 && isPalindrome(suffix)) {
                    another = toIndex.get(reverse(prefix));
                    if (another != null && another != i)
                        ans.add(Arrays.asList(i, another));
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        return true;
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(3));
    }
}
