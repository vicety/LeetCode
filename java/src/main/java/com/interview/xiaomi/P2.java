package com.interview.xiaomi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    /* Write Code Here */
    public Node  Convert(Node pRootOfTree) {
        Stack<Node> stack = new Stack<>();
        Node now = pRootOfTree;
        while (now != null) {
            stack.add(now);
            now = now.left;
        }
        Node first = stack.peek();
        Node prev = null;
        while (!stack.isEmpty()) {
            now = stack.pop();
            if (prev != null) {
                prev.right = now;
                now.left = prev;
            }
            if (now.right != null) {
                Node tmp = now.right;
                while (tmp != null) {
                    stack.add(tmp);
                    tmp = tmp.left;
                }
            }
            prev = now;
        }
//        Thread
        return first;
    }
}

public class P2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Node res = null;
        List<Node> list = new ArrayList<>();

        while (in.hasNext()) {
            int item = in.nextInt();
            if (item == -1) {
                list.add(null);
            } else {
                list.add(new Node(item));
            }
        }
        int len = list.size();
        int i = 0;
        while (i <= (len - 2) / 2) {
            if (2 * i + 1 < len && list.get(i) != null) {
                list.get(i).left = list.get(2 * i + 1);
            }
            if (2 * i + 2 < len && list.get(i) != null) {
                list.get(i).right = list.get(2 * i + 2);
            }
            i++;
        }

        res = new Solution().Convert(list.get(0));
        if (res != null) {
            while (res.right != null && res.data != -1) {
                System.out.print(String.valueOf(res.data) + " ");
                res = res.right;
            }
            System.out.print(res.data + " ");
            while (res.left != null && res.data != -1) {
                System.out.print(String.valueOf(res.data) + " ");
                res = res.left;
            }
            System.out.print(res.data);
        }
        System.out.println();
    }
}
