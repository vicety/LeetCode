package com.company.leetCode;

import java.util.*;

public class P140_2 {
    private int toInt(char c) {
        return c - 'a';
    }

    private class Node {
        char c;
        Node[] next = new Node[26];
        boolean end;
    }

    private class Trie {
        public Node root = new Node();

        public void addWord(String word) {
            addWordInner(word, root, 0);
        }

        private void addWordInner(String word, Node now, int nowIndex) {
            int nowChar = toInt(word.charAt(nowIndex));
            if (now.next[nowChar] == null) {
                now.next[nowChar] = new Node();
                now.next[nowChar].c = word.charAt(nowIndex);
            }
            if (nowIndex == word.length() - 1) {
                now.next[nowChar].end = true;
                return;
            } else addWordInner(word, now.next[nowChar], nowIndex + 1);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        List<List<Integer>> next = new ArrayList<>();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (String word : wordDict) trie.addWord(word);
        for (int i = 0; i < s.length(); i++) {
            // 不包括i，前面的都已经处理好
            next.add(new ArrayList<>());
            if (dp[i] == 1) {
                Node nowNode = trie.root;
                int nowIndex = i;
                while (true) {
                    if (nowIndex >= s.length()) break;
                    int nowChar = toInt(s.charAt(nowIndex));
                    if (nowNode.next[nowChar] == null) break;
                    if (nowNode.next[nowChar].end) {
                        next.get(i).add(nowIndex);
                        dp[nowIndex + 1] = 1;
                    }
                    nowNode = nowNode.next[nowChar];
                    nowIndex++;
                }
            }
        }

        if (dp[s.length()] == 0) return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) ans.add(new ArrayList<>());
        ans.get(s.length()).add("");
        for (int i = s.length() - 1; i >= 0; i--) {
            for (Integer nextIndex : next.get(i)) {
                for (String str : ans.get(nextIndex + 1)) {
                    ans.get(i).add(s.substring(i, nextIndex + 1) + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        return ans.get(0);
//        return dfs(next, s, 0, new HashMap<>());
    }

    private List<String> dfs(List<List<Integer>> next, String s, int st, Map<String, List<String>> memory) {
        if (memory.containsKey(s)) return memory.get(s);
        if (s.isEmpty()) return new ArrayList<>(Collections.singletonList(""));
        List<String> tmpAns = new ArrayList<>();
        for (Integer nextIndex : next.get(st)) {
            List<String> nextAns = dfs(next, s.substring(nextIndex + 1 - st), nextIndex + 1, memory);
            for (String str : nextAns) {
                tmpAns.add(s.substring(0, nextIndex + 1 - st) + (str.isEmpty() ? "" : " ") + str);
            }
        }
        memory.put(s, tmpAns);
        return tmpAns;
    }

    public static void main(String[] args) {
        P140_2 p140 = new P140_2();
//        System.out.println(p140.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
        System.out.println(p140.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
    //
    //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
}
