package com.company.leetCode;

import java.util.*;

public class P39 {
    class Unit {
        int[] content;
        int val;

        Unit(int[] content, int val) {
            this.content = content;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Unit unit = (Unit) o;
            return val == unit.val &&
                    Arrays.equals(content, unit.content);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(val);
            result = 31 * result + Arrays.hashCode(content);
            return result;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Unit>> intermediateAns = new ArrayList<>();
        Set<Unit> st = new HashSet<>();
//        st.add(new Unit(new int[]{0}, 0));
        for (int candidate : candidates) {
            List<Integer> now = new ArrayList<>();
            int val = 0;
            while (val <= target) {
                now.add(candidate);
                val += candidate;
                if (val < target) st.add(new Unit(now.stream().mapToInt(i -> i).toArray(), val));
            }
        }
        if (st.contains(new Unit(new int[]{target}, target))) ans.add(new ArrayList<>(Arrays.asList(target)));
        List<Unit> li = new ArrayList<>(st);
        li.sort((o1, o2) -> o1.val - o2.val);
        int l = 0, r = li.size() - 1;
        while (l < r) {
            int cal = li.get(l).val + li.get(r).val;
            if (cal == target) {
                List<Integer> oneAns = new ArrayList<Integer>();
                for (int item : li.get(l).content) {
                    oneAns.add(item);
                }
                for (int item : li.get(r).content) {
                    oneAns.add(item);
                }
                ans.add(oneAns);
                l++;
                r--;
            } else if (cal < target) l++;
            else r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        P39 p39 = new P39();
        System.out.println(p39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
