package com.company.leetCode.utils;



import java.util.LinkedList;
import java.util.Queue;

class TmpTreeNode extends TreeNode {
    public boolean isNull;

    TmpTreeNode(boolean isNull) {
        super(-1);
        this.isNull = isNull;
    }
}

public class TreeBuilder {

    static private TreeNode processNode(TmpTreeNode node) {
        if (node == null || node.isNull) return null;
        return new TreeNode(node.val);
    }

    static TreeNode copyTree(TmpTreeNode now) {
        if(now == null) return null;
        TreeNode root = processNode(now);
        if(root == null) return null;
        root.left = copyTree((TmpTreeNode) now.left);
        root.right = copyTree((TmpTreeNode) now.right);
        return root;
    }

    static public TreeNode buildTree(Integer[] val) {
        if (val == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TmpTreeNode tmpRoot = new TmpTreeNode(true);
        TmpTreeNode now = tmpRoot;
        q.add(now);
        for (Integer i : val) {
            now = (TmpTreeNode) q.poll();
            if(i == null) continue;
            now.val = i;
            now.isNull = false;
            now.left = new TmpTreeNode(true);
            now.right = new TmpTreeNode(true);
            q.add(now.left);
            q.add(now.right);
        }

        // rebuild tree
        TreeNode ret = copyTree(tmpRoot);
        return ret;
    }

    public static void main(String[] args) {
        buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
    }
}
