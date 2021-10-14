package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P85_2 {
    private int solveLine(int[] heights) {
        int ans = 0;
        List<Integer> list = IntStream.of(heights).boxed().collect(Collectors.toList());
        list.add(0);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!st.empty() && list.get(st.peek()) > list.get(i)) {
                int height = list.get(st.pop());
                ans = Math.max(ans, height * (st.empty() ? i : (i - st.peek() - 1)));
            }
            st.add(i);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') height[j] = height[j] + 1;
                else height[j] = 0;
            }
            ans = Math.max(ans, solveLine(height));
        }
        return ans;
    }
}
