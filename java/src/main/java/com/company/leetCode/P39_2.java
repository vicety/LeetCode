package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

// 没想到是一道搜索……
public class P39_2 {

    List<List<Integer>> ans;
    int[] candidate;
    int target;

    void dfs(int now, int nowIndex, List<Integer> nowAns) {
        if(now == target) {
            ans.add(new ArrayList<>(nowAns));
            return;
        }
        if(now > target) return;
        for(int i = nowIndex; i < candidate.length; i++) {
            nowAns.add(candidate[i]);
            dfs(now + candidate[i], i, nowAns);
            nowAns.remove(nowAns.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        candidate = candidates;
        this.target = target;
        dfs(0, 0, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        P39_2 p39_2 = new P39_2();
        System.out.println(p39_2.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
