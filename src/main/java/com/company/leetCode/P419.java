package com.company.leetCode;

/**
 * @author vicety
 * @date 2020/4/13 2:03
 */
public class P419 {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length;
        int n = board[0].length;
        int last = 0;
        int duplicate = 0;
        for (int i = 0; i < m; i++) {
            last = 0;
            for (int j = 0; j < n; j++) {
                if(board[i][j] == '.') last = 0;
                else {
                    if(last == 1) duplicate++;
                    else last = 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            last = 0;
            for(int j = 0; j < m; j++) {
                if(board[j][i] == '.') last = 0;
                else {
                    if(last == 0) {
                        cnt++;
                        last = 1;
                    }
                }
            }
        }
        return cnt - duplicate;
    }
}
