package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vicety
 * @date 2020/4/11 23:49
 */
public class P412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3 && mod5) ans.add("FizzBuzz");
            else if (mod3) ans.add("Fizz");
            else if (mod5) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        return ans;
    }
}
