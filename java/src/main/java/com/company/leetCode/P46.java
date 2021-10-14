package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P46 {

    List<List<Integer>> ans;

    private void dfs(int now, int[] nums, Set<Integer> vis, List<Integer> nowAns) {
        vis.add(nums[now]);
        nowAns.add(nums[now]);
        if(vis.size() == nums.length) {
            ans.add(new ArrayList<>(nowAns));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!vis.contains(nums[i])) {
                dfs(i, nums, vis, nowAns);
                nowAns.remove(nowAns.size() - 1);
                vis.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> vis = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            dfs(i, nums, new HashSet<>(), new ArrayList<>());
        }
        return ans;
    }
}
