package com.company.leetCode;

public class P211 {
    class WordDictionary {
        private int toInt(char c) {
            return (int) c - 'a';
        }

        class Node {
            Node[] son;
            boolean hasValue;

            Node() {
                son = new Node[26];
            }
        }

        class Trie {
            public Node root = new Node();

            public void insertWord(char[] word, int nowIndex, Node now) {
                if (nowIndex == word.length) {
                    now.hasValue = true;
                    return;
                }
                Node nxt = now.son[toInt(word[nowIndex])];
                if (nxt == null) nxt = now.son[toInt(word[nowIndex])] = new Node();
                insertWord(word, nowIndex + 1, nxt);
            }

            public boolean find(char[] word, int nowIndex, Node now) {
                if (nowIndex == word.length) return now.hasValue;
                boolean ans = false;
                if(word[nowIndex] == '.') {
                    for(int i = 0; i < 26; i++) {
                        Node nxt = now.son[i];
                        if(nxt == null) continue;
                        if(find(word, nowIndex + 1, nxt)) return true;
                    }
                    return false;
                }
                else {
                    Node nxt = now.son[toInt(word[nowIndex])];
                    if (nxt == null) return false;
                    return find(word, nowIndex + 1, nxt);
                }
            }
        }

        Trie trie;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            trie = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            trie.insertWord(word.toCharArray(), 0, trie.root);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return trie.find(word.toCharArray(), 0, trie.root);
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
