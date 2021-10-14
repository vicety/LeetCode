package com.company.leetCode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P179 {
    public String largestNumber(int[] nums) {
        List<String> strs = IntStream.of(nums).boxed().map(String::valueOf).collect(Collectors.toList());
        strs.sort((s1, s2) -> {
            String s1s2 = s1 + s2;
            String s2s1 = s2 + s1;
            for(int i = 0; i < s1s2.length(); i++) {
                if(s1s2.charAt(i) > s2s1.charAt(i)) return -1;
                else if(s1s2.charAt(i) < s2s1.charAt(i)) return 1;
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        strs.forEach(sb::append);
        String res = sb.toString();
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}
