package com.company.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P282 {


    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(ans, num, 0, new StringBuilder(), 0, null, target);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i).substring(1));
        }
        return ans;
    }

    private void addAnswer(List<String> ans, StringBuilder nowExp, char operator, int val, int removeSize) {
        nowExp.append(operator).append(val);
        ans.add(nowExp.toString());
        nowExp.delete(nowExp.length() - removeSize, nowExp.length());
    }

    // all stores 123 -> all Expression
    // memExp stores 123 -> all Exp and 12 -> xx 1 -> xx
    private void solve(List<String> ans, String exp, int nowIndex,
                       StringBuilder nowExp, int nowVal, Integer prev, int target) {
        for (int i = nowIndex + 1; i <= exp.length(); i++) {
            int nowNum = Integer.parseInt(exp.substring(nowIndex, i));
            if (i == exp.length()) {
                if (prev == null && nowVal == target) {
                    ans.add(nowNum + "");
                } else {
                    if (prev != null && nowVal + prev * nowNum == target) {
                        addAnswer(ans, nowExp, '*', nowNum, 1 + i - nowIndex);
                    }

                    return;
                }

            }

            if (prev != null) {
                nowExp.append('*').append(nowNum);
                solve(ans, exp, i, nowExp, nowVal + nowNum * prev, null, target);
                solve(ans, exp, i, nowExp, nowVal, nowNum * prev, target);
                nowExp.delete(nowExp.length() - (1 + i - nowIndex), nowExp.length());
            } else {
                nowExp.append('+').append(nowNum);
                solve(ans, exp, i, nowExp, nowVal + nowNum, null, target);
                nowExp.delete(nowExp.length() - (1 + i - nowIndex), nowExp.length());
                if (nowIndex != 0) {
                    nowExp.append('-').append(nowNum);
                    solve(ans, exp, i, nowExp, nowVal - nowNum, null, target);
                    nowExp.delete(nowExp.length() - (1 + i - nowIndex), nowExp.length());
                    nowExp.append('*').append(nowNum);
                    solve(ans, exp, i, nowExp, nowVal, nowNum, target);
                    nowExp.delete(nowExp.length() - (1 + i - nowIndex), nowExp.length());
                }

            }
        }
    }

    public static void main(String[] args) {
        P282 p282 = new P282();
        System.out.println(p282.addOperators("105", 5));
    }
}
