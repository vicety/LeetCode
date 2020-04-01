package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P460 {
    // TODO
}

class LFUCache {

    Map<Integer, Node> mp;
    Node tail;
    Integer capacity;

    private static class Node {
        Node prev;
        Node next;
        Integer freq;
        Integer key;
        Integer val;


        public Node(Node prev, Node next, Integer freq, Integer key, Integer val) {
            this.prev = prev;
            this.next = next;
            this.freq = freq;
            this.key = key;
            this.val = val;
        }
    }

    public LFUCache(int capacity) {
        mp = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (mp.containsKey(key)) return key;
        return -1;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node cur = mp.get(key);
            cur.freq++;
            cur.val = value;
            flow(cur);
        } else {
            Node newNode = new Node(null, null, 1, key, value);
            if (mp.size() < capacity) {
                insertToEnd(newNode);
            } else {
                mp.remove(tail.key);
                replaceEnd(newNode);
            }
            mp.put(key, newNode);
            flow(newNode);
        }
    }

    private void swapNode(Node prev, Node next) {
        if (tail == next) tail = prev;
        prev.next = next.next;
        next.prev = prev.prev;
        prev.prev = next;
        next.next = prev;
    }

    private Node insertToEnd(Node node) {
        if (tail == null) {
            tail = node;
            return node;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
        return node;
    }

    private Node flow(Node node) {
        while (node.prev != null && node.freq >= node.prev.freq) {
            swapNode(node.prev, node);
        }
        return node;
    }

    private Node replaceEnd(Node node) {
        Node prev = tail.prev;
        if (prev != null) prev.next = node;
        node.prev = prev;
        return node;
    }
}