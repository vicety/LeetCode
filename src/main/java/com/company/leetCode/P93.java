package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P93 {
    private boolean valid(String str) {
        if(str.length() == 0 || str.length() > 3) return false;
        int i = Integer.parseInt(str);
        return i <= 255 && i >= 0;
    }

    private void dfs(List<List<String>> ans, List<String> nowAns, String nowStr, String s, int now) {
        if(nowAns.size() > 4) return;
        if(now == s.length()) {
            if(nowStr.isEmpty()) ans.add(new ArrayList<>(nowAns));
            return;
        }
        if(nowStr.isEmpty() || valid(nowStr)) {
            if(valid(nowStr)) {
                nowAns.add(nowStr);
                dfs(ans, nowAns, String.valueOf(s.charAt(now)), s, now + 1);
                nowAns.remove(nowAns.size() - 1);
            }
            dfs(ans, nowAns, nowStr + s.charAt(now), s, now + 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), "", s, 0);
        List<String> ret = new ArrayList<>();
        for(List<String> oneResult : ans) {
            for(int i = 0; i < oneResult.size(); i++) {
                System.out.print(oneResult.get(i) + " | ");
            }
            System.out.println();
            StringBuilder sb = new StringBuilder();
            for(String str : oneResult) {
                sb.append(str + '.');
            }
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
        }
        return ret;
    }

    public static void main(String[] args) {
        P93 p93 = new P93();
        p93.restoreIpAddresses("25525511135");
    }
}
