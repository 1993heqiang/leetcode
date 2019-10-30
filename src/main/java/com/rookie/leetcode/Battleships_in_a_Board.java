package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/11/7.
 */
public class Battleships_in_a_Board {
    public static void main(String args[]){
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        long t1 = System.nanoTime();
        int ret = countBattleships(board);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int countBattleships(char[][] board) {
        int res = 0, height = board.length, width = board[0].length, i, j;
        for (i = 0; i < height; i++)
            for (j = 0; j < width; j++) {
                if(board[i][j]=='.'){
                    continue;
                }else {
                    if((i > 0 && board[i - 1][j] == 'X')||(j > 0 && board[i][j - 1] == 'X')){
                        j++;
                        continue;
                    }
                    res++;
                }
            }
        return res;
    }
}