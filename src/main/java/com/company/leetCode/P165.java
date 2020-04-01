package com.company.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P165 {

    public int compareVersion(String version1, String version2) {
        String[] v1Split = version1.split("\\.");
        String[] v2Split = version2.split("\\.");
        List<String> v1 = new ArrayList<>(Arrays.asList(v1Split));
        List<String> v2 = new ArrayList<>(Arrays.asList(v2Split));
        int p1 = 0, p2 = 0;
        while(p1 < v1.size() && p2 < v2.size()) {
            int i1 = Integer.parseInt(v1.get(p1));
            int i2 = Integer.parseInt(v2.get(p2));
            if(i1 > i2) return 1;
            else if(i2 > i1) return -1;
            p1++;
            p2++;
        }
        while(p1 < v1.size()) {
            if(Integer.parseInt(v1.get(p1)) != 0) return 1;
            p1++;
        }
        while(p2 < v2.size()) {
            if(Integer.parseInt(v2.get(p2)) != 0) return -1;
            p2++;
        }
        return 0;
    }
}
