package com.company;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class tmp1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int n1 = n;
        String s = in.nextLine().strip();
        char[] color = new char[n];
        Map<Integer, List<Integer>> connect = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            color[i] = s.charAt(i);
        }
        while (n1 != 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n1 -= 1;
            int a = in.nextInt();
            int b = in.nextInt();
            connect.computeIfAbsent(a, k -> new ArrayList<>());
            connect.computeIfAbsent(b, k -> new ArrayList<>());
            connect.get(a).add(b);
            connect.get(b).add(a);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 0;
        }
        dfs(1, vis, 0, 0, ans, color, connect);
        int aans = 0;
        for (int i = 0; i < n; i++) {
            aans += ans[i];
        }

        System.out.println(aans);
        return;
    }

    public static void dfs(int now, Set<Integer> vis, int nowBlue, int nowRed, int[] ans, char[] color, Map<Integer, List<Integer>> conn) {
        vis.add(now);
        if (color[now] == 'R') {
            nowRed++;
        } else if (color[now] == 'B') {
            nowBlue++;
        }
        ans[now] = Math.abs(nowRed - nowBlue);
        List<Integer> next = conn.get(now);
        for (int i = 0; i < next.size(); i++) {
            int nn = next.get(i);
            if (vis.contains(nn)) {
                continue;
            }
            dfs(nn, vis, nowBlue, nowRed, ans, color, conn);
        }
    }
}