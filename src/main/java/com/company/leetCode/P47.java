package com.company.leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P47 {

    Map<Integer, Integer> mp;
    List<List<Integer>> ans;
    List<Integer> arr;

    private void solve(List<Integer> now, Map<Integer, Integer> nowMp) {
        if (now.size() == arr.size()) {
            ans.add(new ArrayList<>(now));
            return;
        }
        for (Integer k : nowMp.keySet()) {
            if (now.size() != 0 && k.equals(now.get(now.size() - 1))) continue;
            if (nowMp.get(k) == 0) continue;
            for (int i = 1; i <= nowMp.get(k); i++) {
                for (int j = 0; j < i; j++) now.add(k);
                nowMp.put(k, nowMp.get(k) - i);
                solve(now, nowMp);
                nowMp.put(k, nowMp.get(k) + i);
                for (int j = 0; j < i; j++) now.remove(now.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 对于duplicate的，每次选1-n个，下一次强制要求不能选相同的
        mp = new HashMap<>();
        arr = IntStream.of(nums).boxed().collect(Collectors.toList());
        ans = new ArrayList<>();
        for (int num : nums) {
            mp.computeIfPresent(num, (k, v) -> v + 1);
            mp.putIfAbsent(num, 1);
        }
        solve(new ArrayList<>(), mp);
        return ans;
    }

    public static void main(String[] args) {
        P47 p47 = new P47();
        List<List<Integer>> ans = p47.permuteUnique(new int[]{1, 1, 2});
        for(int i = 0; i < ans.size(); i++) {
            for(int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
