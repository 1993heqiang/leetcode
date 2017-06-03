package com.heqaing.leetcode;

import java.util.Arrays;

/**
 * Created by HeQiang on 2017/6/3.
 */
public class Range_Addition_II {
    public static void main(String[] args){
        int m = 3,n = 3;
        int[][] ops = {{2,2},{3,3}};
        long t1 = System.nanoTime();
        int result = maxCount(m,n,ops);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(result);
    }
    public static int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for(int i=0;i<ops.length;i++){
            if(ops[i][0]<row) row = ops[i][0];
            if(ops[i][1]<col) col = ops[i][1];
        }
        return row * col;
    }
}
