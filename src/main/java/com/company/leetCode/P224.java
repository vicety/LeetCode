package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P224 {
    public int calculate(String s) {
        String[] postPolish = toPostPolish(s);
        return evalPostPolish(postPolish);
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private int priority(char c) {
        if (c == '+' || c == '-') return 1;
        return 2;
    }

    private String[] toPostPolish(String s) {
        List<String> ans = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<>();
        s = s.replace(" ", "");
        boolean hasNumber = false;
        int num = 0;
        int minus = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                hasNumber = true;
            } else {
                if ((c == '+' || c == '-') && (i == 0 || isOperator(s.charAt(i - 1)) || s.charAt(i - 1) == '(')) {
                    if (c == '-') minus *= -1;
                    continue;
                }
                if (hasNumber) {
                    ans.add(num * minus + "");
                    minus = 1;
                    num = 0;
                    hasNumber = false;
                }
                if (isOperator(c)) {
                    while (!operatorStack.empty() && operatorStack.peek() != '(' && priority(operatorStack.peek()) >= priority(c)) {
                        ans.add(operatorStack.pop() + "");
                    }
                    operatorStack.push(c);
                } else if (c == '(') operatorStack.push('(');
                else if (c == ')') {
                    while (operatorStack.peek() != '(') ans.add(operatorStack.pop() + "");
                    operatorStack.pop();
                }
            }
        }
        if (hasNumber) ans.add(num * minus + "");
        while (!operatorStack.empty()) ans.add(operatorStack.pop() + "");
//        System.out.println(ans);
        return ans.toArray(new String[0]);
    }

    private int evalPostPolish(String[] postPolish) {
        Stack<Integer> numStack = new Stack<>();
        for (String str : postPolish) {
            if (str.length() == 1 && isOperator(str.toCharArray()[0])) {
                char c = str.toCharArray()[0];
                int b = numStack.pop();
                int a = numStack.pop();
                switch (c) {
                    case '+':
                        numStack.push(a + b);
                        break;
                    case '-':
                        numStack.push(a - b);
                        break;
                    case '*':
                        numStack.push(a * b);
                        break;
                    default:
                        numStack.push(a / b);
                        break;
                }
            } else numStack.push(Integer.valueOf(str));
        }
        return numStack.peek();
    }

    public static void main(String[] args) {
        P224 p224 = new P224();
        System.out.println(p224.calculate("-1+2*-3++4*(5+6*7-8)-+9+(-10)"));
        System.out.println(p224.calculate("-1-2-3"));
        System.out.println(p224.calculate("1 + 1"));
    }
}
