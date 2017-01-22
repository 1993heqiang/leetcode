package com.heqaing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/10.
 */
public class Number_of_Boomerangs {
    public static void main(String args[]){
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        long t1 = System.nanoTime();
        int ret = numberOfBoomerangs(points);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int len = points.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i == j)
                    continue;
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for(int val : map.values()) {
                res += val * (val-1);
            }
            map.clear();
        }

        return res;
    }
    private static int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
