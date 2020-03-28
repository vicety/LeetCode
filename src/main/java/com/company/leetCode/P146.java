package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P146 {

}

class LRUCache {

    Map<Integer, Node> mp;
    Node head;
    Node tail;
    Integer capacity;

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(Node prev, Node next, int key, int val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        tail = head = new Node(null, null, -1, -1);
        mp = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(mp.containsKey(key)) {
            refreshNode(key);
            return head.next.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            refreshNode(key);
            mp.get(key).val = value;
            return;
        }
        if(mp.size() >= capacity) {
            Node tailNode = expungeTail();
            mp.remove(tailNode.key);
        }
        Node newNode = new Node(null, null, key, value);
        mp.put(key, newNode);
        insertToHead(newNode);
    }

    private void refreshNode(Integer key) {
        Node node = mp.get(key);
        deleteNode(node);
        insertToHead(node);
    }

    private void deleteNode(Node node) {
        if(tail == node) tail = node.prev;
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        if(tail == head) tail = node;
        node.next = head.next;
        if(head.next != null) head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private Node expungeTail() {
        Node ret = tail;
        Node prev = tail.prev;
        prev.next = null;
        tail = prev;
        return ret;
    }
}
