package com.heqaing.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2016/11/24.
 */
public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static void main(String args[]){
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        long t1 = System.nanoTime();
        int ret = findMinArrowShots(points);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0) return 0;
        // sort points based on their end point.
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2)
            {
                return (p1[1] < p2[1]) ? -1 : ((p1[1] == p2[1]) ? 0 : 1);
            }
        });
        int currentEnd = points[0][1];
        int count = 1;
        for(int[] p: points)
        {
            // if the point starts after currentEnd, it means this balloons not been bursted. Then we shot the balloon in its end point. Otherwise, means this balloon has been bursted, then ignore it.
            if(p[0]>currentEnd) {
                count++;
                currentEnd = p[1];
            }
            else continue;
        }
        return count;
    }
}
