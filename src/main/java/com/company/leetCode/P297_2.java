package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.*;

public class P297_2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append('[');
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            if (now == null) {
                sb.append("null,");
                continue;
            }
            sb.append(now.val).append(',');
            queue.add(now.left);
            queue.add(now.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] strData = data.substring(1, data.length() - 1).split(",");
        List<Integer> intData = new ArrayList<>();
        for (String str : strData) {
            if (str.equals("null")) intData.add(null);
            else intData.add(Integer.parseInt(str));
        }
        Queue<Integer> val = new LinkedList<>(intData);
        Queue<TreeNode> fa = new LinkedList<>();
        TreeNode ret = new TreeNode(val.poll());
        fa.add(ret);
        while (!val.isEmpty()) {
            TreeNode father = fa.poll();
            Integer lvalue = val.poll();
            Integer rvalue = val.poll();
            TreeNode lson, rson;
            if (lvalue != null) lson = new TreeNode(lvalue);
            else lson = null;
            if (rvalue != null) rson = new TreeNode(rvalue);
            else rson = null;
            father.left = lson;
            father.right = rson;
            if (lson != null) fa.add(lson);
            if (rson != null) fa.add(rson);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("1,2,,3,".split(",")));
    }
}
