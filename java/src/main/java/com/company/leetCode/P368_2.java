package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P368_2 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> choices = new ArrayList<>();
        dfs(choices, new ArrayList<>(), nums, 0);
        for (List<Integer> choice : choices) {
            if (choice.size() > ans.size()) ans = choice;
        }
        return ans;
    }

    private void dfs(List<List<Integer>> choices, List<Integer> path, int[] nums, int now) {
        if (now == nums.length) {
            choices.add(new ArrayList<>(path));
            return;
        }
        if (path.size() == 0 || nums[now] % path.get(path.size() - 1) == 0) {
            path.add(nums[now]);
            dfs(choices, path, nums, now + 1);
            path.remove(path.size() - 1);
        }
        dfs(choices, path, nums, now + 1);
    }
}
