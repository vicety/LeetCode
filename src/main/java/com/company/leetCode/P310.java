package com.company.leetCode;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class P310 {
    private class Node {
        List<Integer> next = new ArrayList<>();
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            nodes[a].next.add(b);
            nodes[b].next.add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> tmp = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        int farest = 0;
        q.add(0);
        vis.add(0);
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                int now = q.poll();
                farest = now;
                for (int next : nodes[now].next) {
                    if (vis.contains(next)) continue;
                    tmp.add(next);
                    vis.add(next);
                }
            }
            q = tmp;
            tmp = new LinkedList<>();
        }

        vis.clear();
        vis.add(farest);
        q.clear();
        q.add(farest);
        int[] prev = new int[n];
        int another = -1;
        prev[farest] = -1;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                int now = q.poll();
                another = now;
                for (int next : nodes[now].next) {
                    if (vis.contains(next)) continue;
                    vis.add(next);
                    prev[next] = now;
                    tmp.add(next);
                }
            }
            q = tmp;
            tmp = new LinkedList<>();
        }
        List<Integer> path = new ArrayList<>();
        int now = another;
        while(now != -1) {
            path.add(now);
            now = prev[now];
        }
        List<Integer> ans = new ArrayList<>();
        if (path.size() % 2 == 1) ans.add(path.get(path.size() / 2));
        else {
            ans.add(path.get(path.size() / 2));
            ans.add(path.get(path.size() / 2 - 1));
        }
        return ans;
    }

}
