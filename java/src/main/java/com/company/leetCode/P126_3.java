package com.company.leetCode;

import java.util.*;

public class P126_3 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> vis = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        int minPathLen = Integer.MAX_VALUE;
        if (!wordList.contains(endWord)) return ans;

        // init
        dict.add(endWord);
        vis.add(beginWord);
        List<String> curPath = new ArrayList<>();
        curPath.add(beginWord);
        q.add(curPath);

        while (!q.isEmpty()) {
            List<List<String>> batch = new ArrayList<>(q);
            q.clear();
            Set<String> batchVis = new HashSet<>();
            System.out.println(batch.get(0).size());
            System.out.println(minPathLen);
            if (batch.get(0).size() >= minPathLen) break;
            for (List<String> path : batch) {
//                for (String s : path) {
//                    System.out.print(s + " ");
//                }
//                System.out.println();

                for (String nxtStr : getConnectedNodes(path.get(path.size() - 1), dict)) {
                    if (vis.contains(nxtStr)) continue;
                    path.add(nxtStr);
                    if (nxtStr.equals(endWord)) {
                        ans.add(path);
                        System.out.println("path: " + path.size());
                        minPathLen = Math.min(minPathLen, path.size());
                    } else {
                        batchVis.add(nxtStr);
                        q.add(new ArrayList<>(path));
                    }
                }
            }
            vis.addAll(batchVis);
        }
        return ans;
    }

    private List<String> getConnectedNodes(String now, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < now.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newStr = now.substring(0, i) + c + now.substring(i + 1, now.length());
                if (dict.contains(newStr))
                    ans.add(newStr);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P126 p126 = new P126();
        p126.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        for (List<String> an : p126.ans) {
            for (String s : an) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
