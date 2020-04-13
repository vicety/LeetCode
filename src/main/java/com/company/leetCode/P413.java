package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vicety
 * @date 2020/4/12 0:02
 */
public class P413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(2, 0);
        for (int i = 3; i <= A.length; i++) {
            cache.put(i, cache.get(i - 1) + (i - 2));
        }
        int ans = 0;
        int interval = A[1] - A[0];
        int seqSize = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == interval) seqSize++;
            else {
                ans += cache.get(seqSize);
                interval = A[i] - A[i - 1];
                seqSize = 2;
            }
        }
        ans += cache.get(seqSize);
        return ans;
    }
}
