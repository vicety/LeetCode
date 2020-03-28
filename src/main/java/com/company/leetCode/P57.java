package com.company.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P57 {
    private class Interval {
        int st;
        int ed;

        public Interval(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> list = new ArrayList<>();
        List<Interval> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }
        list.add(new Interval(newInterval[0], newInterval[1]));
        list.sort(Comparator.comparingInt(a -> a.st));
        int cur = 0;

        while (cur < list.size()) {
            int st = list.get(cur).st;
            int ed = list.get(cur).ed;
            int pIntervalEd = cur + 1;
            while (pIntervalEd < list.size() && list.get(pIntervalEd).st <= ed) {
                ed = Math.max(ed, list.get(pIntervalEd).ed);
                pIntervalEd++;
            }
            ans.add(new Interval(st, ed));
            cur = pIntervalEd;
        }

        // List<Interval> -> List<int[]> -> int[][]
        return ans.stream().map(interval -> new int[]{interval.st, interval.ed}).collect(Collectors.toList()).toArray(new int[ans.size()][2]);
    }
}
