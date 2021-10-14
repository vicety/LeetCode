package com.company.leetCode;

import java.util.*;

public class P352 {
    class SummaryRanges {

        private Map<Integer, Integer> map;
        private Map<Integer, List<Integer>> toInterval;
        private Set<Integer> rootSet;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            map = new HashMap<>();
            toInterval = new HashMap<>();
            rootSet = new HashSet<>();
        }

        public void addNum(int val) {
            if(map.containsKey(val)) return;
            map.put(val, val);
            toInterval.put(val, Arrays.asList(val, val));
            rootSet.add(val);
            if(map.containsKey(val - 1)) merge(val, val - 1);
            if(map.containsKey(val + 1)) merge(val, val + 1);
        }

        public int[][] getIntervals() {
            int[][] ans = new int[rootSet.size()][2];
            int now = 0;
            int[] keys = rootSet.stream().sorted().mapToInt(i ->i).toArray();
            for(int root : keys) {
                ans[now][0] = toInterval.get(root).get(0);
                ans[now++][1] = toInterval.get(root).get(1);
            }
            return ans;
        }

        private int find(int x) {
            int fa = map.get(x);
            if(x == fa) return x;
            int ans = find(fa);
            map.put(x, ans);
            return ans;
        }

        private void merge(int a, int b) {
            int afa = find(a);
            int bfa = find(b);
            map.put(afa, bfa); // save to bfa
            rootSet.remove(afa);
            int al = toInterval.get(afa).get(0), ar = toInterval.get(afa).get(1);
            int bl = toInterval.get(bfa).get(0), br = toInterval.get(bfa).get(1);
            if(ar == bl - 1) toInterval.put(bfa, Arrays.asList(al, br));
            else toInterval.put(bfa, Arrays.asList(bl, ar));
        }
    }

    public static void main(String[] args) {
        P352 p352 = new P352();
        SummaryRanges summaryRanges = p352.new SummaryRanges();
//        summaryRanges.addNum(1);
//        summaryRanges.addNum(3);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(2);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        List<Integer> li = Arrays.asList(2,3,1);
        System.out.println(Arrays.toString(li.stream().sorted().mapToInt(i -> i).toArray()));
    }
}
