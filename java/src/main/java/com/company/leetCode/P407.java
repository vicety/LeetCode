package com.company.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author vicety
 * @date 2020/4/11 21:12
 */
public class P407 {
    private class Point {
        int y, x, val;

        public Point(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        int minBorderHeight = Integer.MIN_VALUE;
        int ans = 0;
        if (m <= 2 || n <= 2) return 0;
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        int[][] vis = new int[m][n];
        for (int i = 0; i < n; i++) {
            pq.add(new Point(0, i, heightMap[0][i]));
            pq.add(new Point(m - 1, i, heightMap[m - 1][i]));
            vis[0][i] = 1;
            vis[m - 1][i] = 1;
        }
        for (int j = 1; j < m - 1; j++) {
            pq.add(new Point(j, 0, heightMap[j][0]));
            pq.add(new Point(j, n - 1, heightMap[j][n - 1]));
            vis[j][0] = 1;
            vis[j][n - 1] = 1;
        }
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            minBorderHeight = Math.max(minBorderHeight, point.val);
            int y = point.y;
            int x = point.x;
            if (y + 1 < m && vis[y + 1][x] == 0) {
                if (heightMap[y + 1][x] < minBorderHeight) ans += minBorderHeight - heightMap[y + 1][x];
                pq.add(new Point(y + 1, x, heightMap[y + 1][x]));
                vis[y + 1][x] = 1;
            }
            if (y - 1 >= 0 && vis[y - 1][x] == 0) {
                if (heightMap[y - 1][x] < minBorderHeight) ans += minBorderHeight - heightMap[y - 1][x];
                pq.add(new Point(y - 1, x, heightMap[y - 1][x]));
                vis[y - 1][x] = 1;
            }
            if (x + 1 < n && vis[y][x + 1] == 0) {
                if (heightMap[y][x + 1] < minBorderHeight) ans += minBorderHeight - heightMap[y][x + 1];
                pq.add(new Point(y, x + 1, heightMap[y][x + 1]));
                vis[y][x + 1] = 1;
            }
            if (x - 1 >= 0 && vis[y][x - 1] == 0) {
                if (heightMap[y][x - 1] < minBorderHeight) ans += minBorderHeight - heightMap[y][x - 1];
                pq.add(new Point(y, x - 1, heightMap[y][x - 1]));
                vis[y][x - 1] = 1;
            }
        }
        return ans;
    }
}
