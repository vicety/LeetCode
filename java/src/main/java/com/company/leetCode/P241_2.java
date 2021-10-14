package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P241_2 {
    public List<Integer> diffWaysToCompute(String input) {
        return solve(new HashMap<>(), input);
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*');
    }

    private List<Integer> solve(Map<String, List<Integer>> cache, String input) {
        if (cache.get(input) != null) return cache.get(input);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isOperator(c)) {
                List<Integer> left = solve(cache, input.substring(0, i));
                List<Integer> right = solve(cache, input.substring(i + 1));
                for(int a :left) {
                    for(int b : right) {
                        switch (c) {
                            case '+':
                                ans.add(a + b);
                                break;
                            case '-':
                                ans.add(a - b);
                                break;
                            default:
                                ans.add(a * b);
                                break;
                        }
                    }
                }
            }
        }
        if(ans.isEmpty()) ans.add(Integer.parseInt(input));
        cache.put(input, ans);
        return ans;
    }

    public static void main(String[] args) {
        P241_2 p241_2 = new P241_2();
        System.out.println(p241_2.diffWaysToCompute("2*3-4*5"));
    }
}
