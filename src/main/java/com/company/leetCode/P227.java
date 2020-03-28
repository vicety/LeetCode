package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P227 {
    public int calculate(String s) {
        List<String> postPolish = toPostPolish(s);
        return evalPostPolish(postPolish);
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private int priority(char c) {
        if (c == '+' || c == '-') return 1;
        else return 2;
    }

    private List<String> toPostPolish(String s) {
        s = s.replace(" ", "");
        List<String> ans = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<Character>();
        int now = 0;
        boolean hasNumber = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                hasNumber = true;
                now = now * 10 + c - '0';
            } else {
                if (hasNumber) {
                    hasNumber = false;
                    ans.add(now + "");
                    now = 0;
                }
                while (!operatorStack.empty() && priority(c) <= priority(operatorStack.peek())) {
                    ans.add(operatorStack.pop() + "");
                }
                operatorStack.add(c);
            }
        }
        if (hasNumber) ans.add(now + "");
        while (!operatorStack.empty()) ans.add(operatorStack.pop() + "");
        System.out.println(ans);
        return ans;
    }

    private int evalPostPolish(List<String> postPolish) {
        Stack<Integer> ans = new Stack<>();
        for (String str : postPolish) {
            if (str.length() == 1 && isOperator(str.toCharArray()[0])) {
                char c = str.toCharArray()[0];
                int b = ans.pop();
                int a = ans.pop();
                switch (c) {
                    case '+':
                        ans.push(a + b);
                        break;
                    case '-':
                        ans.push(a - b);
                        break;
                    case '*':
                        ans.push(a * b);
                        break;
                    default:
                        ans.push(a / b);
                        break;
                }
            } else ans.push(Integer.valueOf(str));
        }
        return ans.peek();
    }

    public static void main(String[] args) {
        P227 p227 = new P227();
        System.out.println(p227.calculate("3+2*2"));
    }
}
