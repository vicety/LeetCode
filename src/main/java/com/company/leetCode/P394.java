package com.company.leetCode;

import java.util.Stack;

public class P394 {
    public String decodeString(String s) {
        Stack<Integer> repeat = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int repeatNum = 0;
        StringBuilder nowStringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) repeatNum = repeatNum * 10 + (c - '0');
            else if (c == '[') {
                repeat.add(repeatNum);
                stringStack.add(nowStringBuilder);
                repeatNum = 0;
                nowStringBuilder = new StringBuilder();
            } else if (c == ']') {
                String tmp = nowStringBuilder.toString();
                for (int j = 1; j < repeat.peek(); j++) nowStringBuilder.append(tmp);
                tmp = nowStringBuilder.toString();
                if (stringStack.isEmpty()) return tmp;
                nowStringBuilder = stringStack.pop();
                nowStringBuilder.append(tmp);
                repeat.pop();
            } else nowStringBuilder.append(c);
        }
        return nowStringBuilder.toString();
    }

    public static void main(String[] args) {
        P394 p394 = new P394();
        System.out.println(p394.decodeString("2[2[a]b]"));
    }
}
