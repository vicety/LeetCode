package com.company.leetCode;

import java.util.*;

public class P399 {

    class Edge {
        String to;
        double val;

        public Edge(String to, double val) {
            this.to = to;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            map.computeIfAbsent(a, k -> new ArrayList<>());
            map.get(a).add(new Edge(b, val));
            map.computeIfAbsent(b, k -> new ArrayList<>());
            map.get(b).add(new Edge(a, 1 / val));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = solve(map, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1), 1);
//            System.out.println("---");
        }
        return ans;
    }

    private double solve(Map<String, List<Edge>> map, Set<String> vis, String from, String to, double now) {
//        System.out.println(String.format("%s %s", from, to));
        if (!map.containsKey(from) || !map.containsKey(to)) return -1;
        if (from.equals(to)) return now;
        vis.add(from);
        for (Edge edge : map.get(from)) {
            if(!vis.contains(edge.to)) {
                double ret = solve(map, vis, edge.to, to, now * edge.val);
                if(ret != -1) return ret;
            }
        }
        vis.remove(from);
        return -1;
    }
}
