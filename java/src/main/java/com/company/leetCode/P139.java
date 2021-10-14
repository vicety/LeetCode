package com.company.leetCode;

import java.util.List;

public class P139 {
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

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            if (word.length() > 0)
                trie.addWord(word);
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (dp[i - 1] == 1) {
                Node nowNode = trie.root;
                int nowChar;
                int nowIndex = i - 1;
                while (true) {
                    if (nowIndex >= s.length()) break;
                    nowChar = toInt(s.charAt(nowIndex));
                    if (nowNode.next[nowChar] == null) break;
                    if (nowNode.next[nowChar].end) dp[nowIndex + 1] = 1;
                    nowNode = nowNode.next[nowChar];
                    nowIndex++;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}
