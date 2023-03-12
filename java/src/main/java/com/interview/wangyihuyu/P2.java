package com.interview.wangyihuyu;

import java.util.*;

public class P2 {
    static class Rec {
        int i1;
        int j1;
        int i2;
        int j2;

        public Rec(int i1, int j1, int i2, int j2) {
            this.i1 = i1;
            this.j1 = j1;
            this.i2 = i2;
            this.j2 = j2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int mini = 2000;
            int maxi = -1;
            int minj = 2000;
            int maxj = -1;
            int n = sc.nextInt();
            sc.nextLine();
            List<Rec> recs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                String[] seg = line.split(" ");
                mini = Math.min(mini, Integer.parseInt(seg[0]));
                mini = Math.min(mini, Integer.parseInt(seg[2]));
                maxi = Math.max(maxi, Integer.parseInt(seg[0]));
                maxi = Math.max(maxi, Integer.parseInt(seg[2]));

                minj = Math.min(minj, Integer.parseInt(seg[1]));
                minj = Math.min(minj, Integer.parseInt(seg[3]));
                maxj = Math.max(maxj, Integer.parseInt(seg[1]));
                maxj = Math.max(maxj, Integer.parseInt(seg[3]));

                recs.add(new Rec(Integer.parseInt(seg[0]),
                        Integer.parseInt(seg[1]),
                        Integer.parseInt(seg[2]),
                        Integer.parseInt(seg[3])));
            }

            for (Rec rec : recs) {
                rec.i1 -= mini;
                rec.i2 -= mini;
                rec.j1 -= minj;
                rec.j2 -= minj;
            }
            maxi -= mini;
            maxj -= minj;

            int ans = 0;
            Set<Rec> vis = new HashSet<>();
            Set<Rec>[][] map = new Set[maxi][maxj];
            for (int i = 0; i < maxi; i++) {
                for (int j = 0; j < maxj; j++) {
                    map[i][j] = new HashSet<>();
                }
            }

            for (Rec rec : recs) {
                boolean cover;
                for (int i = rec.i1; i < rec.i2; i++) {
                    for (int j = rec.j1; j < rec.j2; j++) {
                        for (Rec rec1 : map[i][j]) {
                            if (!vis.contains(rec1)) {
                                ans += ((rec1.i2 - rec1.i1) * (rec1.j2 - rec1.j1));
                                vis.add(rec1);
                            }
                            if (!vis.contains(rec)) {
                                ans += ((rec.i2 - rec.i1) * (rec.j2 - rec.j1));
                            }
                        }
                        if (map[i][j].size() > 0) {
                            ans--;
                        }
                        map[i][j].add(rec);
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
