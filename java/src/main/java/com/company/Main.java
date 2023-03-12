package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][3];
        a[0] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        a[1] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        a[2] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] tmp1 = map.getOrDefault(a[0][i] - 1, new int[2]);
            int[] tmp2 = map.getOrDefault(a[1][i], new int[2]);
            tmp1[a[2][i] - 1]--;
            tmp2[a[2][i] - 1]++;
            map.put(a[0][i] - 1, tmp1);
            map.put(a[1][i], tmp2);
        }
        List<Map.Entry<Integer, int[]>> list = new ArrayList<>();
        for (Map.Entry<Integer, int[]> v : map.entrySet()) {
            list.add(v);
        }
        Collections.sort(list, (x, y) -> {
            return y.getKey() - x.getKey();
        });
        // System.out.println(list.size());
        int res = 0;
        int curp = 0, curq = 0;
        int lastk = -1;
        for (Map.Entry<Integer, int[]> v : list) {
            int tmpk = v.getKey();
            //System.out.println(tmpk);
            int[] tmpv = v.getValue();
            if (lastk == -1) {
                curp += tmpv[0];
                curq += tmpv[1];
                lastk = tmpk;
            } else {
                if (curp >= p && curq >= q) {
                    res += lastk - tmpk;
                }
                curp += tmpv[0];
                curq += tmpv[1];
                lastk = tmpk;
            }
        }
        System.out.println(res);
    }
}