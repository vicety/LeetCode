package com.company.leetCode;

import java.util.Stack;

public class P331 {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        Stack<String> stack = new Stack<>();
        boolean treeEmptiedOnce = false;
        for (String str : list) {
            if (stack.isEmpty()) {
                if (treeEmptiedOnce) return false;
                treeEmptiedOnce = true;
            }
            if (str.equals("#")) {
                while (!stack.empty()) {
                    String vis = stack.pop();
                    String node = stack.pop();
                    if (vis.equals("0")) {
                        stack.push(node);
                        stack.push("1");
                        break;
                    }
                }
            } else {
                stack.push(str);
                stack.push("0");
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        P331 p331 = new P331();
        System.out.println(p331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(p331.isValidSerialization("1,#"));
        System.out.println(p331.isValidSerialization("9,#,#,1"));
        System.out.println(p331.isValidSerialization("1,#,#,#,#"));
    }
}
