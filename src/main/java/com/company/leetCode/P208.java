package com.company.leetCode;

public class P208 {
    class Trie {

        class Node {
            boolean end;
            Node[] next = new Node[256];
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node now = root;
            for (char c : word.toCharArray()) {
                if (now.next[c] == null) now.next[c] = new Node();
                now = now.next[c];
            }
            now.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node now = root;
            for (char c : word.toCharArray()) {
                if (now.next[c] == null) return false;
                now = now.next[c];
            }
            return now.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node now = root;
            for (char c : prefix.toCharArray()) {
                if(now.next[c] == null) return false;
                now = now.next[c];
            }
            return true;
        }
    }
}
