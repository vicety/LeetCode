package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P140 {
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

        public boolean searchWord(String word) {
            return searchWordInner(word, root, 0);
        }

        private boolean searchWordInner(String word, Node now, int nowIndex) {
            int nowChar = toInt(word.charAt(nowIndex));
            if (now.next[nowChar] == null) return false;
            if (nowIndex == word.length() - 1) return now.next[nowChar].end;
            return searchWordInner(word, now.next[nowChar], nowIndex + 1);
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

    private void dfs(List<String> ans, List<List<Integer>> next, List<String> path, String s, int now) {
        if (now == s.length()) {
            ans.add(String.join(" ", path));
            return;
        }
        for (Integer nextIndex : next.get(now)) {
            path.add(s.substring(now, nextIndex + 1));
            dfs(ans, next, path, s, nextIndex + 1);
            path.remove(path.size() - 1);
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

//        List<String> ans = new ArrayList<>();
//        dfs(ans, next, new ArrayList<>(), s, 0);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) ans.add(new ArrayList<>());
        ans.get(s.length()).add("");
        for (int i = s.length() - 1; i >= 0; i--) {
            for (Integer nextIndex : next.get(i)) {
                for (String str : ans.get(nextIndex + 1)) {
                    ans.get(i).add(s.substring(i, nextIndex +1) + " " + str);
                }
            }
        }
        return ans.get(0);
//        return ans;
    }

    public static void main(String[] args) {
        P140 p140 = new P140();
        System.out.println(p140.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
