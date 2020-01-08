package com.rookie.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals instance = new NonOverlappingIntervals();
        int[][] input = new int[][]{{1, 2}, {3, 4}};
        int result = instance.eraseOverlapIntervals(input);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Compare());
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (end > interval[0]) {
                count++;
                if (end > interval[1]) end = interval[1];
            } else {
                end = interval[1];
            }
        }
        return count;
    }

    private static class Compare implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        }
    }
}
