package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TLE
public class P332 {
    private class Edge {
        String to;
        boolean vis;

        public Edge(String to) {
            this.to = to;
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Edge>> map = new HashMap<>();
        for (List<String> edge : tickets) {
            String from = edge.get(0);
            String to = edge.get(1);
            map.computeIfAbsent(from, k -> new ArrayList<>());
            map.get(from).add(new Edge(to));
        }
        List<String> ansSet = new ArrayList<>();
        dfs(map, ansSet, new StringBuilder(), "JFK", null, 0, tickets.size());
        String ans = ansSet.get(0);
        for (int i = 1; i < ansSet.size(); i++) {
            if (greaterThan(ans, ansSet.get(i))) ans = ansSet.get(i);
        }
        return splitString(ans);
    }

    private void dfs(Map<String, List<Edge>> map, List<String> ansSet, StringBuilder path, String now, Edge nowEdge, int nowN, int n) {
        if(map.get(now) == null && nowN != n) return;
        path.append(now);
        if (nowN == n) {
            ansSet.add(path.toString());
            nowEdge.vis = false;
            path.setLength(path.length() - 3);
            return;
        }
        for (Edge edge : map.get(now)) {
            if (edge.vis) continue;
            edge.vis = true;
            dfs(map, ansSet, path, edge.to, edge, nowN + 1, n);
            edge.vis = false;
        }
        path.setLength(path.length() - 3);
    }

    private boolean greaterThan(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) return true;
            else if (a.charAt(i) < b.charAt(i)) return false;
        }
        return true;
    }

    private List<String> splitString(String str) {
        List<String> ans = new ArrayList<>();
        int p = 0;
        while (p < str.length()) {
            ans.add(str.substring(p, p + 3));
            p += 3;
        }
        return ans;
    }

    public static void main(String[] args) {
        P332 p332 = new P332();
        List<List<String>> data = new ArrayList<>();
//        data.add(Stream.of(new String[]{"MUC", "LHR"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"JFK", "MUC"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"SFO", "SJC"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"LHR", "SFO"}).collect(Collectors.toList()));

//        data.add(Stream.of(new String[]{"JFK", "SFO"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"JFK", "ATL"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"SFO", "ATL"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"ATL", "JFK"}).collect(Collectors.toList()));
//        data.add(Stream.of(new String[]{"ATL", "SFO"}).collect(Collectors.toList()));

        data.add(Stream.of(new String[]{"JFK", "KUL"}).collect(Collectors.toList()));
        data.add(Stream.of(new String[]{"JFK", "NRT"}).collect(Collectors.toList()));
        data.add(Stream.of(new String[]{"NRT", "JFK"}).collect(Collectors.toList()));
        System.out.println(p332.findItinerary(data));
    }
}
