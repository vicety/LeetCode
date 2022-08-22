package com.company.leetCode;

//import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;

public class P241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<String> expression = parseIntoStringList(input);

        return null;
    }

    private boolean isOperator(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*"));
    }

    private int priority(String str) {
        if (str.equals("*")) return 2;
        return 1;
    }

    private void getPossibleExpressions(List<List<String>> ans, int nowLeftParenthesis, int nowRightParenthesis, int maxParenthesis, List<String> path, List<String> origin, int nowIndex, int nowNum) {
        if (nowIndex == origin.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        String nowElement = origin.get(nowIndex);
        if (isOperator(nowElement)) {
            path.add(nowElement);
            getPossibleExpressions(ans, nowLeftParenthesis, nowRightParenthesis, maxParenthesis, path, origin, nowIndex + 1, nowNum);
            path.remove(path.size() - 1);
        } else {
            // 左括号探索一切可能性，右括号只确保必要个数，nowNum从1开始
            int leftMax = maxParenthesis - nowLeftParenthesis;
            int leftMin = Math.max(0, nowNum - nowLeftParenthesis);
            int remainingNum = maxParenthesis + 2 - nowNum;
//            int rightMin = leftMin == 0 ? 1 : 0;
//            rightMin = Math.max(rightMin, maxParenthesis - remainingNum);
        }
    }

    private List<String> parseIntoStringList(String input) {
        List<String> ans = new ArrayList<>();
        int now = 0;
        boolean hasNumber = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!hasNumber) hasNumber = true;
                now = now * 10 + c - '0';
            } else {
                if (hasNumber) {
                    ans.add(now + "");
                    hasNumber = false;
                    now = 0;
                }
                ans.add(c + "");
            }
        }
        return ans;
    }
}
