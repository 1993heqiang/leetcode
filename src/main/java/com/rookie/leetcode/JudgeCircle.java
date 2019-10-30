package com.rookie.leetcode;

/**
 * Created by HeQiang on 2017/10/7.
 */

public class JudgeCircle {
    public static void main(String args[]){
        String moves = "UD";
        boolean ret = judgeCircle(moves);
        System.out.println(ret);
    }
    public static boolean judgeCircle(String moves) {
        int len = moves.length();
        if(len==0||(len&1)==1){
            return false;
        }
        char[] movesArr = moves.toCharArray();
        int u = 0,l = 0;
        for(int i=0;i<len;i++){
            if('U'==movesArr[i]){
                u++;
            }else if('D'==movesArr[i]){
                u--;
            }else if('L'==movesArr[i]){
                l++;
            }else if('R'==movesArr[i]){
                l--;
            }else {
                return false;
            }
        }
        if(u==0&&l==0) return true;
        return false;
    }
}
