package com.company.leetCode;

//import org.springframework.web.context.ContextLoaderListener;

import java.util.*;

public class P207 {
    private class Node {
        List<Integer> nextNodes = new ArrayList<>();
        List<Integer> prerequisites = new ArrayList<>();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) nodes[i] = new Node();
        for (int[] edge : prerequisites) {
            int to = edge[0];
            int from = edge[1];
            nodes[from].nextNodes.add(to);
            nodes[to].prerequisites.add(from);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < numCourses; i++)
            if (nodes[i].prerequisites.isEmpty()) {
                q.add(i);
            }
        while (!q.isEmpty()) {
            Integer nowIndex = q.poll();
            vis.add(nowIndex);
            Node now = nodes[nowIndex];
            for (Integer next : now.nextNodes) {
                if (vis.contains(next)) continue;
                int mark = 0;
                for (Integer pre : nodes[next].prerequisites) {
                    if (!vis.contains(pre)) {
                        mark = 1;
                        break;
                    }
                }
                if (mark == 0) q.add(next);
            }
        }
        for (int i = 0; i < numCourses; i++) if (!vis.contains(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        P207 p207 = new P207();
        System.out.println(p207.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{0, 1}}));
    }
}
