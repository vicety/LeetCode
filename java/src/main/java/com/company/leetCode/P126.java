package com.company.leetCode;

import java.util.*;

public class P126 {
    List<List<String>> ans;
    Map<String, Integer> mp;

    private void dfs(String now, String endWord, List<String> path) {
        if (ans.size() != 0 && path.size() >= ans.get(0).size()) return;
//        for (String s : path) {
//            System.out.print(s + ' ');
//        }
//        System.out.println();
        char[] chs = now.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char originalC = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chs[i] = c;
                String str = new String(chs);
                if (str.equals(endWord)) {
                    path.add(str);
                    if (ans.size() != 0 && path.size() < ans.get(0).size()) ans.clear();
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                } else if (mp.get(str) != null && mp.get(str) >= path.size() + 1) {
                    mp.put(str, path.size() + 1);
                    path.add(str);
                    dfs(str, endWord, path);
                    path.remove(path.size() - 1);
                }
                chs[i] = originalC;
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        mp = new HashMap<>();
        for (String s : wordList) {
            mp.put(s, Integer.MAX_VALUE);
        }
        mp.put(beginWord, 1);
        if (!wordList.contains(endWord)) return new ArrayList<>();
        ans = new ArrayList<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        dfs(beginWord, endWord, beginList);
        return ans;
    }

    public static void main(String[] args) {
        P126 p126 = new P126();
        p126.findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        for (List<String> an : p126.ans) {
            for (String s : an) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
