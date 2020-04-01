package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P205 {
    private int[] buildForm(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int cnt = 0;
        int[] ret = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(!mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), cnt);
                ret[i] = cnt++;
            }
            else ret[i] = mp.get(s.charAt(i));
        }
        return ret;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] sForm = buildForm(s);
        int[] tForm = buildForm(t);
        for(int i = 0; i < sForm.length; i++) {
            if(sForm[i] != tForm[i]) return false;
        }
        return true;
    }
}
