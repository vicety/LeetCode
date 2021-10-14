package com.company.leetCode;

import java.util.*;

public class P354_2 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        List<Integer> dp = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int h = envelope[1];
            if (dp.isEmpty() || h > dp.get(dp.size() - 1)) dp.add(h);
            else if (h < dp.get(dp.size() - 1)) {
                int l = 0, r = dp.size() - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (dp.get(mid) >= h) r = mid - 1;
                    else l = mid + 1;
                }
                dp.set(l, h);
            }
        }
        return dp.size();
    }
}
