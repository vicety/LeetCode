package com.company.leetCode;

import java.util.*;

public class P126_2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return res;
        }
        //set.clear();
        set.add(beginWord);
        set.add(endWord);
        // construct graph
        Map<String, List<String>> map = new HashMap<>();
        // 表示到start word的最短变化距离
        Map<String, Integer> distance = new HashMap<>();

        bfs(map, distance, beginWord, endWord, set);

        List<String> path = new ArrayList<>();
        dfs(res, path, endWord, beginWord, distance, map);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path,
                     String cur, String start, Map<String, Integer> distance,
                     Map<String, List<String>> map) {
        path.add(cur);
        if (cur.equals(start)) {
            Collections.reverse(path);
            res.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(cur)) {
                if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
                    dfs(res, path, next, start, distance, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
                     String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> nextList = expand(cur, dict);
            for (String next : nextList) {
                map.get(next).add(cur);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(cur) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    private List<String> expand(String cur, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j != cur.charAt(i)) {
                    String item = cur.substring(0, i) + j + cur.substring(i + 1);
                    if (dict.contains(item)) {
                        res.add(item);
                    }
                }
            }
        }
        return res;
    }
}
