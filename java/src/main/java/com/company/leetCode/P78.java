package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P78 {

    List<List<Integer>> ans;

    private void dfs(int[] nums, int now, List<Integer> nowAns) {
        if(now == nums.length) {
            ans.add(new ArrayList<>(nowAns));
            return;
        }
        dfs(nums, now + 1, nowAns);
        nowAns.add(nums[now]);
        dfs(nums, now + 1, nowAns);
        nowAns.remove(nowAns.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
}
