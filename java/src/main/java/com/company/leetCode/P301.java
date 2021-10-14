package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P301 {
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb1 = new StringBuilder();
        int st = Integer.MAX_VALUE, ed = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st = i;
                break;
            } else if (s.charAt(i) != ')') sb1.append(s.charAt(i));
        }
        StringBuilder sb2 = new StringBuilder();
        int bound = Math.max(0, st);
        for (int i = s.length() - 1; i > bound; i--) {
            if (s.charAt(i) == ')') {
                ed = i;
                break;
            } else if (s.charAt(i) != '(') sb2.append(s.charAt(i));
        }
        s = sb1.toString() + (ed > st ? s.substring(st, ed + 1) : "") + sb2.toString();
        int lCnt = 0, rCnt = 0, l = 0, r = 0;
        List<List<String>> segments = new ArrayList<>();
        while (r < s.length()) {
            while (r < s.length() && lCnt >= rCnt) {
                char c = s.charAt(r);
                if (c == '(') lCnt++;
                else if (c == ')') rCnt++;
                r++;
            }
            if (lCnt > rCnt) break;
            else segments.add(processRight(s.substring(l, r), rCnt - lCnt));
            lCnt = 0;
            rCnt = 0;
            l = r;
        }

        List<List<String>> reverseSegment = new ArrayList<>();
        s = s.substring(l, r);
        s = (new StringBuilder(s)).reverse().toString();
        lCnt = 0;
        rCnt = 0;
        l = 0;
        r = 0;
        while (r < s.length()) {
            while (r < s.length() && rCnt >= lCnt) {
                char c = s.charAt(r);
                if (c == '(') lCnt++;
                else if (c == ')') rCnt++;
                r++;
            }
            if (lCnt > rCnt) reverseSegment.add(processLeft(s.substring(l, r), lCnt - rCnt));
            else break;
            lCnt = 0;
            rCnt = 0;
            l = r;
        }
        List<String> mid = new ArrayList<>();
        mid.add((new StringBuilder(s.substring(l, r))).reverse().toString());
        reverseSegment.add(mid);
        for (int i = reverseSegment.size() - 1; i >= 0; i--) segments.add(reverseSegment.get(i));

        List<String> ans = new ArrayList<>();
        dfs(segments, ans, 0, new StringBuilder());
        return ans;
    }

    private void dfs(List<List<String>> candidates, List<String> ans, int now, StringBuilder path) {
        if (now == candidates.size()) {
            ans.add(path.toString());
            return;
        }
        int size = candidates.get(now).get(0).length();
        for (String str : candidates.get(now)) {
            path.append(str);
            dfs(candidates, ans, now + 1, path);
            path.setLength(path.length() - size);
        }
    }

    private List<String> processLeft(String s, int diff) {
        List<String> ret = new ArrayList<>();
        processInner(ret, s, new StringBuilder(), 0, diff, '(');
        for (int i = 0; i < ret.size(); i++) {
            ret.set(i, (new StringBuilder(ret.get(i))).reverse().toString());
        }
        return ret;
    }

    private List<String> processRight(String s, int diff) {
        List<String> ret = new ArrayList<>();
        processInner(ret, s, new StringBuilder(), 0, diff, ')');
        return ret;
    }

    private void processInner(List<String> ans, String s, StringBuilder path, int st, int max, char target) {
        if (st == s.length()) {
            if (max != 0) return;
            ans.add(path.toString());
            return;
        }
        int now = st;
        while (now < s.length() && s.charAt(now) != target) now++;
        int targetCnt = 0;
        while (now < s.length() && s.charAt(now) == target) {
            targetCnt++;
            now++;
        }
        int limit = Math.min(targetCnt, max);
        for (int i = 0; i <= limit; i++) {
            path.append(s.substring(st, now - i));
            processInner(ans, s, path, now, max - i, target);
            path.setLength(path.length() - (now - i - st));
        }
    }

    public static void main(String[] args) {
        P301 p301 = new P301();
//        System.out.println(p301.removeInvalidParentheses(")())()())(()("));
//        System.out.println(p301.removeInvalidParentheses("()())()"));
//        System.out.println(p301.removeInvalidParentheses("(a)())()"));
//        System.out.println(p301.removeInvalidParentheses(")("));
//        System.out.println(p301.removeInvalidParentheses("()(()(("));
//        System.out.println(p301.removeInvalidParentheses(")o(v("));
//        System.out.println(p301.removeInvalidParentheses("zw(()"));
        System.out.println(p301.removeInvalidParentheses("(r(()()("));
    }
}
