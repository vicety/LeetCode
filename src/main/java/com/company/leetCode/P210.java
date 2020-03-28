package com.company.leetCode;

import java.util.*;

public class P210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int pAns = 0;
        List<List<Integer>> next = new ArrayList<>();
        List<List<Integer>> prerequisite = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            next.add(new ArrayList<>());
            prerequisite.add(new ArrayList<>());
        }
        for (int[] fromTo : prerequisites) {
            int from = fromTo[1], to = fromTo[0];
            next.get(from).add(to);
            prerequisite.get(to).add(from);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (prerequisite.get(i).isEmpty()) {
            q.offer(i);
            ans[pAns++] = i;
        }
        while (!q.isEmpty()) {
            int nowIndex = q.poll();
            vis.add(nowIndex);
            for (int nextIndex : next.get(nowIndex)) {
                if (vis.contains(nextIndex)) continue;
                boolean flag = false;
                for (int nextPrerequisites : prerequisite.get(nextIndex)) {
                    if(!vis.contains(nextPrerequisites)) {
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
                q.add(nextIndex);
                ans[pAns++] = nextIndex;
            }
        }
        if(pAns != numCourses) return new int[0];
        return ans;
    }
}
