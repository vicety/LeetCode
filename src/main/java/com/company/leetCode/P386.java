package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P386 {
    public List<Integer> lexicalOrder(int n) {
        int cnt = (int) Math.floor(Math.log10(n)) + 1;
        int[] numLimit = new int[cnt];
        int tmp = n;
        int index = cnt - 1;
        while (tmp > 0) {
            numLimit[index] = tmp % 10;
            index--;
            tmp /= 10;
        }
        List<Integer> ans = new ArrayList<>();
        dfs(ans, 0, cnt, 0, numLimit, true);
        return ans;
    }

    private void dfs(List<Integer> ans, int index, int indexLimit, int num, int[] numLimit, boolean reachedLimit) {
        if (index == indexLimit) {
            ans.add(num);
            return;
        }
        int l = 0;
        if((num == 0 && index == indexLimit - 1)) l = 1;
        int r = reachedLimit ? numLimit[index] : 9;
        num *= 10;
        for (int i = l; i <= r; i++) {
            dfs(ans, index + 1, indexLimit, num + i, numLimit, reachedLimit && i == r);
        }
    }

    public static void main(String[] args) {
        P386 p386 = new P386();
        System.out.println(p386.lexicalOrder(23));
    }
}
