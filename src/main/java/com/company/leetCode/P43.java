package com.company.leetCode;

public class P43 {
    private String simpleMultiply(String num1, char num2, int zeros) {
        StringBuilder ans = new StringBuilder();
        int bu = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int res = (num1.charAt(i) - '0') * (num2 - '0') + bu;
            int ge = res % 10;
            bu = res / 10;
            ans.insert(0, ge);
        }
        if (bu > 0) ans.insert(0, bu);
        while (zeros-- != 0) ans.append("0");
        return ans.toString();
    }

    private String add(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder shorterSb = new StringBuilder(len1 > len2 ? num2 : num1);
        String longer = len1 > len2 ? num1 : num2;
        int diff = Math.abs(len1 - len2);
        while (diff-- != 0) shorterSb.insert(0, "0");
        int bu = 0;
        String shorter = shorterSb.toString();
        StringBuilder ans = new StringBuilder();
        for (int i = longer.length() - 1; i >= 0; i--) {
            int res = (longer.charAt(i) - '0') + (shorter.charAt(i) - '0') + bu;
            int ge = res % 10;
            bu = res / 10;
            ans.insert(0, ge);
        }
        if (bu > 0) ans.insert(0, bu);
        return ans.toString();
    }

    public String multiply(String num1, String num2) {
        String ans = "";
        for (int i = num2.length() - 1, zero = 0; i >= 0; i--, zero++) {
            String tmp = simpleMultiply(num1, num2.charAt(i), zero);
            ans = add(ans, tmp);
        }
        // remove leading zero
        if(ans.length() > 1) {
            int st = 0;
            for(int i = 0; i < ans.length() - 1; i++) {
                if(ans.charAt(i) == '0') st++;
                else break;
            }
            ans = ans.substring(st);
        }
        return ans;
    }

    public static void main(String[] args) {
        P43 p43 = new P43();
        System.out.println(p43.multiply("2", "3"));
    }
}
