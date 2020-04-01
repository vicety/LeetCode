package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P391 {
    public boolean isRectangleCover(int[][] rectangles) {
        Integer l = null, r = null, u = null, d = null;
        Map<String, Integer> cnt = new HashMap<>();
        int areaSum = 0;

        for (int[] rectangle : rectangles) {
            int nowL = rectangle[0], nowD = rectangle[1], nowR = rectangle[2], nowU = rectangle[3];
            if (l == null || nowL < l) l = nowL;
            if (r == null || nowR > r) r = nowR;
            if (u == null || nowU > u) u = nowU;
            if (d == null || nowD < d) d = nowD;
            areaSum += (nowU - nowD) * (nowR - nowL);
            String serializedBottomLeft = serialize(nowD, nowL);
            String serializedUpperRight = serialize(nowU, nowR);
            String serializedBottomRight = serialize(nowD, nowR);
            String serializedUpperLeft = serialize(nowU, nowL);
            cnt.put(serializedBottomLeft, cnt.getOrDefault(serializedBottomLeft, 0) + 1);
            cnt.put(serializedUpperRight, cnt.getOrDefault(serializedUpperRight, 0) + 1);
            cnt.put(serializedBottomRight, cnt.getOrDefault(serializedBottomRight, 0) + 1);
            cnt.put(serializedUpperLeft, cnt.getOrDefault(serializedUpperLeft, 0) + 1);
        }

        String serializedBottomLeft = serialize(d, l);
        String serializedUpperRight = serialize(u, r);
        String serializedBottomRight = serialize(d, r);
        String serializedUpperLeft = serialize(u, l);
        if (areaSum != (u - d) * (r - l)) return false;
        if (cnt.get(serializedBottomLeft) == null || cnt.get(serializedUpperRight) == null
                || cnt.get(serializedBottomRight) == null || cnt.get(serializedUpperLeft) == null) return false;
        if (cnt.get(serializedBottomLeft) != 1 || cnt.get(serializedUpperRight) != 1
                || cnt.get(serializedBottomRight) != 1 || cnt.get(serializedUpperLeft) != 1) return false;
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            String key = entry.getKey();
            if (!key.equals(serializedBottomLeft) && !key.equals(serializedUpperRight)
                    && !key.equals(serializedUpperLeft) && !key.equals(serializedBottomRight) && entry.getValue() % 2 != 0)
                return false;
        }
        return true;
    }

    private String serialize(int y, int x) {
        return y + "," + x;
    }
}
