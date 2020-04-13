package com.company.leetCode;

/**
 * @author vicety
 * @date 2020/4/12 1:12
 */
public class P415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num1.length() - num2.length(); i++) sb.append("0");
        num2 = sb.toString() + num2;
        int addition = 0;
        sb.setLength(0);
        for (int i = num1.length() - 1; i >= 0; i--) {
            int result = num1.charAt(i) - '0' + num2.charAt(i) - '0' + addition;
            addition = result / 10;
            sb.append(result % 10);
        }
        if(addition != 0) sb.append(addition);
        return sb.reverse().toString();
    }
}
