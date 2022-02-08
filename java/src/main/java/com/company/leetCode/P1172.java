package com.company.leetCode;

import java.util.*;

public class P1172 {
    public static void main(String[] args) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(2, 3);
//        System.out.println(map.floorKey(1));
//        System.out.println(map.ceilingKey(1));



//        DinnerPlates dinnerPlates = new DinnerPlates(2);
//        dinnerPlates.push(1);
//        dinnerPlates.push(2);
//        dinnerPlates.push(3);
//        dinnerPlates.push(4);
//        dinnerPlates.push(5);
//        System.out.println(dinnerPlates.popAtStack(0));
//        dinnerPlates.push(20);
//        dinnerPlates.push(21);
//        System.out.println(dinnerPlates.popAtStack(0));
//        System.out.println(dinnerPlates.popAtStack(2));
//        System.out.println(dinnerPlates.pop());
//        System.out.println(dinnerPlates.pop());
//        System.out.println(dinnerPlates.pop());
//        System.out.println(dinnerPlates.pop());
//        System.out.println(dinnerPlates.pop());

        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(472);
        dinnerPlates.push(106);
        dinnerPlates.push(497);
        dinnerPlates.push(498);
        dinnerPlates.push(73);
        dinnerPlates.push(115);
        dinnerPlates.push(437);
        dinnerPlates.push(461);
        System.out.println(dinnerPlates.popAtStack(3));
        System.out.println(dinnerPlates.popAtStack(3));
        System.out.println(dinnerPlates.popAtStack(1));
        System.out.println(dinnerPlates.popAtStack(3));
        System.out.println(dinnerPlates.popAtStack(0));
        System.out.println(dinnerPlates.popAtStack(2));
        System.out.println(dinnerPlates.popAtStack(2));
        System.out.println(dinnerPlates.popAtStack(1));
        System.out.println(dinnerPlates.popAtStack(1));
        System.out.println(dinnerPlates.popAtStack(3));
        dinnerPlates.push(197);
        dinnerPlates.push(239); //
        dinnerPlates.push(129);
        dinnerPlates.push(449);
        dinnerPlates.push(460);
        dinnerPlates.push(240);
        dinnerPlates.push(386);
        dinnerPlates.push(343);
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());

        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());

//        dinnerPlates.push(3);
    }
}

class DinnerPlates {

    public int cap;
    public Deque1172 nonFull;
    public Deque1172 nonEmpty;
    public List<Stack<Integer>> stacks;

    public DinnerPlates(int capacity) {
        this.cap = capacity;
        this.nonFull = new Deque1172();
        this.nonEmpty = new Deque1172();
        this.stacks = new ArrayList<>();
    }

    public void push(int val) {
        int pushedIndex = -1;
        // 无任何元素或全满，需要开新空间
        if (nonFull.length() == 0) {
            // 没有任何元素
            if (nonEmpty.length() == 0) {
                pushedIndex = 0;
                if (stacks.size() == 0) {
                    stacks.add(new Stack<>());
                }

            } else {
                pushedIndex = nonEmpty.last() + 1;
                if (stacks.size() < pushedIndex + 1) {
                    stacks.add(new Stack<>());
                }
            }
        } else {
            // 有最左未满，使用它
            pushedIndex = nonFull.first();
        }

        stacks.get(pushedIndex).add(val);

        if (stacks.get(pushedIndex).size() == 1) {
            int floorKey = nonEmpty.indexToNode.floorKey(pushedIndex);
            Node floorNode = nonEmpty.indexToNode.get(floorKey);
            Node nextNode = floorNode.next;
            Node newNode = new Node(pushedIndex);
            floorNode.next = newNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            newNode.prev = floorNode;

            nonEmpty.len += 1;
            nonEmpty.indexToNode.put(pushedIndex, newNode);
            nonEmpty.nodeToIndex.put(newNode, pushedIndex);
        }

        if (nonFull.length() == 0 && stacks.get(pushedIndex).size() < cap) {
            nonFull.append(pushedIndex, pushedIndex);
        } else if (stacks.get(pushedIndex).size() == cap && cap != 1) {
            nonFull.popLeft();
        }
    }

    public int pop() {
        if (nonEmpty.length() == 0) {
            return -1;
        }
        // 否则使用最右非空
        int popedIndex = nonEmpty.last();
        int ret = stacks.get(popedIndex).pop();

        if (stacks.get(popedIndex).size() == cap - 1) {
            nonFull.append(popedIndex, popedIndex); // 实际上可能造成尾巴多个0,0,0
        }
        if (stacks.get(popedIndex).size() == 0) {
            nonEmpty.pop();
        }

        return ret;
    }

    public int popAtStack(int index) {
        if (index > stacks.size() - 1 || stacks.get(index).size() == 0) {
            return -1;
        }

        // 必定存在于nonEmpty
        Node node = nonEmpty.getNodeByIndex(index);
        if (stacks.get(index).size() == 1) {
            nonEmpty.removeNode(node);
        }

        // 创建新的nonFull
        if (stacks.get(index).size() == cap) {
            Integer floorIndex = nonFull.indexToNode.floorKey(index);
            Node floorNode = nonFull.indexToNode.get(floorIndex);

            Node nextNode = floorNode.next;
            Node newNode = new Node(node.val);
            floorNode.next = newNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            newNode.prev = floorNode;

            nonFull.len += 1;
            nonFull.indexToNode.put(index, newNode);
            nonFull.nodeToIndex.put(newNode, index);
        }

        return stacks.get(index).pop();
    }
}


class Deque1172 {
    public Node head = new Node(-1);
    public Node tail = new Node(Integer.MAX_VALUE);
    public int len = 0;
    public TreeMap<Integer, Node> indexToNode = new TreeMap<>();
    public Map<Node, Integer> nodeToIndex = new HashMap<>();

    public Deque1172() {
        head.next = tail;
        tail.prev = head;
        indexToNode.put(-1, head);
        indexToNode.put(Integer.MAX_VALUE, tail);
    }

    public int length() {
        return len;
    }

    public void removeNode(Node node) {
        int index = nodeToIndex.get(node);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

//        TreeSet treeSet = new TreeSet();
//        treeSet.pollFirst()
//        indexToNode.pollFirstEntry()
        
        indexToNode.remove(index);
        nodeToIndex.remove(node);
        len -= 1;
    }

    public Node getNodeByIndex(int index) {
        return indexToNode.get(index);
    }

    public int first() {
        return head.next.val;
    }

    public int last() {
        return tail.prev.val;
    }

    public void append(int index, int val) {
        Node node = new Node(val);
        indexToNode.put(index, node);
        nodeToIndex.put(node, index);
        Node prevNode = tail.prev;
        Node nextNode = tail;
        nextNode.prev = node;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = nextNode;
        len += 1;
    }

    public void appendLeft(int index, int val) {
        Node node = new Node(val);
        indexToNode.put(index, node);
        nodeToIndex.put(node, index);
        Node prevNode = head;
        Node nextNode = head.next;
        nextNode.prev = node;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = nextNode;
        len += 1;
    }

    public int pop() {
        Node nodeToDel = tail.prev;
        int index = nodeToIndex.get(nodeToDel);
        Node prevNode = tail.prev.prev;
        prevNode.next = tail;
        tail.prev = prevNode;
        len -= 1;
        indexToNode.remove(index);
        nodeToIndex.remove(nodeToDel);
        return nodeToDel.val;
    }

    public int popLeft() {
        Node nodeToDel = head.next;
        int index = nodeToIndex.get(nodeToDel);
        Node prevNode = head;
        Node nextNode = head.next.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        len -= 1;
        indexToNode.remove(index);
        nodeToIndex.remove(nodeToDel);
        return nodeToDel.val;
    }
}

class Node {
    public Node(int val) {
        this.val = val;
    }

    public Node prev;
    public Node next;
    public int val;
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */