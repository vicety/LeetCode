package com.company.leetCode;

import com.company.another.A;
import com.company.leetCode.utils.TreeNode;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class P1123 {
}

class Solution_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // find deepest leaves set
        List<TreeNode> bfsCurrent = new ArrayList<>();
        List<TreeNode> bfsNext = new ArrayList<>();
        bfsCurrent.add(root);

        ThreadPoolExecutor

        while (true) {
            for (TreeNode node : bfsCurrent) {
                if (node.left != null) {
                    bfsNext.add(node.left);
                }
                if (node.right != null) {
                    bfsNext.add(node.right);
                }
            }
            if (bfsNext.isEmpty()) {
                break;
            }
            bfsCurrent = bfsNext;
            bfsNext = new ArrayList<>();
        }

        Set<Integer> deepestNodes = bfsCurrent.stream().map(e -> e.val).collect(Collectors.toSet());

        return lca(root, deepestNodes);
    }

    private TreeNode lca(TreeNode current, Set<Integer> targets) {
        if (current == null) {
            return null;
        } else if (targets.contains(current.val)) {
            return current;
        }

        TreeNode leftResult = lca(current.left, targets);
        TreeNode rightResult = lca(current.right, targets);

        if (leftResult != null && rightResult != null) {
            return current;
        } else if (leftResult == null) {
            return rightResult;
        } else {
            // right null or both null
            return leftResult;
        }
    }
}