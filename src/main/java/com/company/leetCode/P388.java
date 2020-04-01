package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P388 {
    class Node {
        boolean isFile;
        String name;
        List<Node> nodes = new ArrayList<>();

        public Node(boolean isFile, String name) {
            this.isFile = isFile;
            this.name = name;
        }
    }

    public int lengthLongestPath(String input) {
//        System.out.println(input);
        if (input.length() == 0) return 0;
        String[] strings = input.split("\n");
        List<Node> stack = new ArrayList<>();
        Node root = new Node(false, "");
        stack.add(root);
        for (String str : strings) {
            int level = 0;
            while (str.charAt(level) == '\t') level++;
            String name = str.substring(level);
            Node node;
            // add for stack[level], set for stack[level + 1], file should not set
            if (name.indexOf('.') != -1) node = new Node(true, name);
            else node = new Node(false, name);
            stack.get(level).nodes.add(node);
            if (!node.isFile) {
                if (level == stack.size() - 1) stack.add(node);
                else stack.set(level + 1, node);
            }
        }
        return dfs(root, 0, 0) - 1;
    }

    // write two versions, int[]{0} and return int
    private int dfs(Node now, int len, int level) {
        if (now.isFile) return len + now.name.length() + (level - 1);
        int ans = 0;
        len += now.name.length();
        for (Node node : now.nodes) {
            ans = Math.max(ans, dfs(node, len, level + 1));
        }
        return ans;
    }
}
