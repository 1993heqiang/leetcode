package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/1/20.
 */
public class ZumaGame {
    public static void main(String args[]){
        String board = "RBYYBBRRB";
        String hand = "YRBGB";
        long t1 = System.nanoTime();
        int ret = findMinStep(board,hand);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findMinStep(String board, String hand) {
        char[] boardArr = board.toCharArray();
        char[] handArr = hand.toCharArray();
        int ret = 0;

        return -1;
    }
}
