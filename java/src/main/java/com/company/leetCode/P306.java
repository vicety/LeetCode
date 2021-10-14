package com.company.leetCode;

public class P306 {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, null, null, false);
    }

    private String strAdd(String a, String b) {
        int size = Math.max(a.length(), b.length());
        int diff = size - Math.min(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff; i++) sb.append('0');
        if (a.length() < b.length()) a = sb.append(a).toString();
        else b = sb.append(b).toString();
        int tmp = 0;
        sb.setLength(0);
        for (int i = a.length() - 1; i >= 0; i--) {
            int result = a.charAt(i) - '0' + b.charAt(i) - '0' + tmp;
            tmp = result / 10;
            sb.append(result % 10);
        }
        if (tmp != 0) sb.append(1);
        return sb.reverse().toString();
    }

    private boolean dfs(String str, int now, String first, String second, boolean hasThird) {
        if (now == str.length()) {
            return hasThird;
        }
        for (int i = now; i < str.length(); i++) {
            String nextNum;
            if (str.charAt(now) == '0') nextNum = "0";
            else nextNum = str.substring(now, i + 1);
            if (first == null) {
                if (dfs(str, i + 1, nextNum, second, hasThird)) return true;
            } else if (second == null) {
                if (dfs(str, i + 1, first, nextNum, hasThird)) return true;
            } else {
                if (!nextNum.equals(strAdd(first, second))) continue;
                else if (dfs(str, i + 1, second, nextNum, true)) return true;
            }
            if (str.charAt(now) == '0') break;
        }
        return false;
    }

    public static void main(String[] args) {
        P306 p306 = new P306();
        System.out.println(p306.isAdditiveNumber("199100199"));
    }
}
