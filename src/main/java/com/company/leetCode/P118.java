package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        if(numRows == 0) return new ArrayList<>();
        else if(numRows == 1) return ans;
        for(int i = 2; i <= numRows; i++) {
            ans.add(new ArrayList<>());
            ans.get(i - 1).add(1);
            for(int j = 0; j < i - 2; j++) ans.get(i - 1).add(ans.get(i - 2).get(j) + ans.get(i - 2).get(j + 1));
            ans.get(i - 1).add(1);
        }
        return ans;
    }
}
