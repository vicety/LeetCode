package com.company.leetCode;

import java.util.*;

public class P126_4 {
    private void bfs(Map<String, Boolean> vis, Set<String> begin, Set<String> end, Map<String, List<String>> next, boolean isFront) {
        if (begin.size() == 0) return;
        if (begin.size() > end.size()) {
            bfs(vis, end, begin, next, !isFront);
            return;
        }
        boolean reached = false;
        Set<String> nextBegin = new HashSet<>();
        for(String str : begin) vis.put(str, true);
        for (String str : begin) {
            for (int i = 0; i < str.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newStr = str.substring(0, i) + c + str.substring(i + 1);
                    if (vis.containsKey(newStr) && !vis.get(newStr)) {
                        if (end.contains(newStr)) reached = true;
                        if (isFront) next.get(str).add(newStr);
                        else next.get(newStr).add(str);
                        nextBegin.add(newStr);
                    }
                }
            }
        }
        if (reached) return;
        else bfs(vis, nextBegin, end, next, isFront);
    }

    private void dfs(List<List<String>> ans, String now, List<String> path, String endWord, Map<String, List<String>> next) {
        path.add(now);
        if (now.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (String nextStr : next.get(now)) {
            dfs(ans, nextStr, path, endWord, next);
        }
        path.remove(path.size() - 1);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList<>();
        wordList.add(beginWord);
        Map<String, List<String>> next = new HashMap<>();
        Map<String, Boolean> vis = new HashMap<>();
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        List<List<String>> ans = new ArrayList<>();
        for (String str : wordList) next.put(str, new ArrayList<>());
        for (String str : wordList) vis.put(str, false);
        bfs(vis, begin, end, next, true);
        dfs(ans, beginWord, new ArrayList<>(), endWord, next);
        return ans;
    }
}
