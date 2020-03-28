package com.company.leetCode;

import com.company.leetCode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P337 {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memPrevVis = new HashMap<>();
        Map<TreeNode, Integer> memPrevNonVis = new HashMap<>();
        return dfs(memPrevVis, memPrevNonVis, root, false);
    }

    private int dfs(Map<TreeNode, Integer> memVis, Map<TreeNode, Integer> memNonVis, TreeNode now, boolean visLast) {
        if (now == null) return 0;
        if (visLast && memVis.containsKey(now)) return memVis.get(now);
        if (!visLast && memNonVis.containsKey(now)) return memNonVis.get(now);
        if (!visLast) {
            int nowBest = Math.max(dfs(memVis, memNonVis, now.left, true) + dfs(memVis, memNonVis, now.right, true) + now.val,
                    dfs(memVis, memNonVis, now.left, false) + dfs(memVis, memNonVis, now.right, false));
            memNonVis.put(now, nowBest);
            return nowBest;
        } else {
            int nowBest = dfs(memVis, memNonVis, now.left, false) + dfs(memVis, memNonVis, now.right, false);
            memVis.put(now, nowBest);
            return nowBest;
        }
    }
}
