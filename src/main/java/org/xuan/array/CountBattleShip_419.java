package org.xuan.array;

/**
 * Created by xzhou2 on 2/21/17.
 */
public class CountBattleShip_419 {
    public int countBattleships(char[][] board) {
        int result = 0;
        if (board.length == 0 || board[0].length == 0) {
            return result;
        }
        int nRow = board.length, nCol = board[0].length;
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                char c = board[i][j];
                if (c == 'X') {
                    if (!(i > 0 && board[i-1][j] == 'X') && !(j > 0 && board[i][j-1] == 'X')) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
