package com.company.leetCode;

import java.util.*;

public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> di = new HashMap<>();

        for(String str: strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String strNormalized = new String(chArr);
            if(!di.containsKey(strNormalized)) {
                di.put(strNormalized, ans.size());
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(str);
            }
            else ans.get(di.get(strNormalized)).add(str);
        }
        return ans;
    }
}
