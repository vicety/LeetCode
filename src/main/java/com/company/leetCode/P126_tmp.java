package com.company.leetCode;

import java.util.*;

public class P126_tmp {
    // backtracking
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        // no possible paths
        if (!wordSet.contains(endWord))
            return res;

        // hashmap of transforms
        Map<String, List<String>> paths = new HashMap<>();
        Set<String> bSet = new HashSet<>(Arrays.asList(beginWord)),
                eSet = new HashSet<>(Arrays.asList(endWord));


        // run bfs to fill paths with list of transforms for each word
        bfs(beginWord.length(), bSet, paths, wordSet, eSet, false);

        // make an empty list to build results
        dfs(beginWord, paths, new ArrayList<>(Arrays.asList(beginWord)), res, endWord);

        return res;
    }

    private void dfs(String beginWord, Map<String, List<String>> paths, List<String> path,
                     List<List<String>> res, String endWord) {
        if (beginWord.equals(endWord)) {
            // we are done
            res.add(path);
            return;
        }

        if (!paths.containsKey(beginWord))
            return;

        for (String ladder : paths.get(beginWord)) {
            // for each transform add it to the list and run dfs on the next level
            path.add(ladder);
            dfs(ladder, paths, new ArrayList<>(path), res, endWord);
            path.remove(path.size() - 1);
        }
    }

    private void bfs(int wSize, Set<String> bSet, Map<String, List<String>> paths,
                     Set<String> wordSet, Set<String> eSet, boolean reversed) {
        if (bSet.isEmpty() || eSet.isEmpty())
            return;

        // switch direction and flag reverse
        if (bSet.size() > eSet.size()) {
            bfs(wSize, eSet, paths, wordSet, bSet, !reversed);
            return;
        }

        Set<String> next = new HashSet<>();
        boolean done = false;
        wordSet.removeAll(bSet);

        for (String word : bSet) {
            char[] w = word.toCharArray();
            for (int i = 0; i < wSize; i++) {
                char origin = w[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    w[i] = ch;
                    String target = new String(w);
                    w[i] = origin;

                    if (wordSet.contains(target)) {
                        next.add(target);
                        // if we are working from the end set we need to swap key and value
                        if (reversed) {
                            paths.putIfAbsent(target, new ArrayList<>());
                            paths.get(target).add(word);
                        } else {
                            paths.putIfAbsent(word, new ArrayList<>());
                            paths.get(word).add(target);
                        }
                        // if we found the shortest path, bfs is done
                        if (eSet.contains(target))
                            done = true;

                    }
                }
            }
        }

        if (done)
            return;

        // call bfs on the next level
        bfs(wSize, next, paths, wordSet, eSet, reversed);
    }

    public static void main(String[] args) {
        P126 p126 = new P126();
        p126.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        for (List<String> an : p126.ans) {
            for (String s : an) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
