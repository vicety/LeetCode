package com.company.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P56 {

    class Unit {
        int val;
        int type;

        public Unit(int val, int type) {
            this.val = val;
            this.type = type;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Unit> lst = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            lst.add(new Unit(intervals[i][0], 1));
            lst.add(new Unit(intervals[i][1], 2));
        }
        lst.sort((o1, o2) -> {
                if(o1.val != o2.val) return o1.val - o2.val;
                return o1.type - o2.type;
        });

        List<List<Integer>> ansLst = new ArrayList<>();
        int l = 0;
        int nowSt = -1;
        for(int i = 0; i < lst.size(); i++) {
            if(l == 0) nowSt = lst.get(i).val;
            if(lst.get(i).type == 1) l++;
            else l--;
            if(l == 0) ansLst.add(
                    IntStream.of(new int[]{nowSt, lst.get(i).val}).boxed().collect(Collectors.toList())
            );
        }
        int[][] ans = new int[ansLst.size()][2];
        for(int i = 0; i < ansLst.size(); i++) {
            ans[i][0] = ansLst.get(i).get(0);
            ans[i][1] = ansLst.get(i).get(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = new int[2][2];
        for(int i = 0; i < 2; i++) for(int j  = 0; j < 2; j++) System.out.println(a[i][j]);
    }
}
