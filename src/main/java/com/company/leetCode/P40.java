package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P40 {

    private int[] candidates;
    private int target;
    private List<List<Integer>> ans;

//    private void collectAll(int now, List<Integer> choice) {
//
//    }

    private void dfs(int now, List<Integer> choice, int sum) {
        if (sum >= target) {
            if (sum == target) ans.add(new ArrayList<>(choice));
            return;
        }
        if (now >= candidates.length) return;
        int tmp = now;
        int cnt = 0;
        int nowNum = candidates[tmp];
        while (tmp < candidates.length && candidates[tmp++] == nowNum) cnt++;
        dfs(now + 1, choice, sum);
        for (int i = 0; i < cnt; i++) choice.add(candidates[now]);
        dfs(now + cnt, choice, sum + candidates[now] * cnt);
        for (int i = 0; i < cnt; i++) choice.remove(choice.size() - 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        dfs(0, new ArrayList<>(), 0);
        return ans;
    }

    public static void main(String[] args) {
        P40 p40 = new P40();
//        System.out.println(p40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        int[] arr = new int[]{1, 2, 3};
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
//        arr = list.toArray();
//        Serializable
//        System.exit();
//                Thread.sleep();
//        System.out.println(IntStream.of(arr).boxed().collect());
    }
}
