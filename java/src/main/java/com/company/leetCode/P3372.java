package com.company.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3372 {

}


class Main {

    static class Tree {
        long val;
        int l;
        int r;
        long lazy;
    }

    private static long[] nums;
    private static Tree[] arr;

    private static int ls(int i) {
        return i << 1;
    }

    private static int rs(int i) {
        return i << 1 | 1;
    }

    private static void up(int rt) {
        arr[rt].val = arr[ls(rt)].val + arr[rs(rt)].val;
    }

    private static void down(int rt) {
        arr[ls(rt)].lazy += arr[rt].lazy;
        arr[ls(rt)].val += arr[rt].lazy * (arr[ls(rt)].r - arr[ls(rt)].l + 1);
        arr[rs(rt)].lazy += arr[rt].lazy;
        arr[rs(rt)].val += arr[rt].lazy * (arr[rs(rt)].r - arr[rs(rt)].l + 1);
        arr[rt].lazy = 0;
    }

    private static void build(int rt, int l, int r) {
        if (l == r) {
            arr[rt].val = nums[l];
            arr[rt].l = l;
            arr[rt].r = r;
            return;
        }
        int mid = (l + r) >> 1;
        build(ls(rt), l, mid);
        build(rs(rt), mid + 1, r);
        up(rt);
        arr[rt].l = l;
        arr[rt].r = r;
    }

    private static long query(int rt, int ql, int qr) {
        if (ql <= arr[rt].l && qr >= arr[rt].r) return arr[rt].val;
        down(rt);
        long res = 0;
        int mid = (arr[rt].l + arr[rt].r) >> 1;
        if (ql <= mid) res += query(ls(rt), ql, qr);
        if (qr > mid) res += query(rs(rt), ql, qr);
        return res;
    }

    private static void update(int rt, int ul, int ur, long val) {
        if (ul <= arr[rt].l && ur >= arr[rt].r) {
            arr[rt].val += (arr[rt].r - arr[rt].l + 1) * val;
            arr[rt].lazy += val;
            return;
        }
        down(rt);
        int mid = (arr[rt].l + arr[rt].r) >> 1;
        if (ul <= mid) update(ls(rt), ul, ur, val);
        if (ur > mid) update(rs(rt), ul, ur, val);
        up(rt);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(r);
        StringBuilder sb = new StringBuilder();
        String[] line = in.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        nums = new long[N];
        arr = new Tree[N << 2];
        for (int i = 0; i < arr.length; i++) arr[i] = new Tree();

        String[] aStr = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(aStr[i]);
        }
        build(1, 0, N - 1);

        for (int i = 0; i < M; i++) {
            String[] ops = in.readLine().split(" ");
            int x = Integer.parseInt(ops[1]);
            int y = Integer.parseInt(ops[2]);
            if (ops.length == 3) {
                long res = query(1, x - 1, y - 1);
                sb.append(res);
                sb.append("\n");
            } else if (ops.length == 4) {
                long k = Long.parseLong(ops[3]);
                update(1, x - 1, y - 1, k);
            }
        }
        System.out.println(sb);
    }
}
