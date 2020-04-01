package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P90 {

    private void dfs(List<List<Integer>> ans, Map<Integer, Integer> mp, List<Integer> list, List<Integer> nowList, int now) {
        if(now == list.size()) {
            ans.add(new ArrayList<>(nowList));
            return;
        }
        for(int i = 0; i <= mp.get(list.get(now)); i++) {
            for(int j = 1; j <= i; j++) nowList.add(list.get(now));
            dfs(ans, mp, list, nowList, now + 1);
            for(int j = 1; j <= i; j++) nowList.remove(nowList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(mp.keySet());
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, mp, list, new ArrayList<>(), 0);
        return ans;
    }
}
