package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P93_2 {
    private boolean valid(String str) {
        int i = Integer.parseInt(str);
        if((i != 0 && str.charAt(0) == '0') || (i == 0 &&str.length() > 1)) return false;
        return i >= 0 && i <= 255;
    }

    private void dfs(List<String> ans, StringBuilder sb, String s, int now, int nowGroup) {
        if (nowGroup > 4) return;
        if (now == s.length()) {
            if(nowGroup == 4) ans.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (now + i <= s.length()) {
                String thisGroup = s.substring(now, now + i);
                if (valid(thisGroup)) {
                    sb.append(thisGroup);
                    if(nowGroup < 3) sb.append('.');
                    dfs(ans, sb, s, now + i, nowGroup + 1);
                    if(nowGroup < 3) sb.deleteCharAt(sb.length() - 1);
                    sb.delete(sb.length() - i, sb.length());
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), s, 0, 0);
        return ans;
    }
}
