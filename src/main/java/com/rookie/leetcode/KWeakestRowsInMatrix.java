package com.rookie.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix {
    public static void main(String[] args) {
        KWeakestRowsInMatrix instance = new KWeakestRowsInMatrix();
        int[][] mat = new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;
        int[] result = instance.kWeakestRows(mat, k);
        System.out.println(Arrays.toString(result));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int value : mat[i]) {
                if (value != 1) {
                    break;
                } else {
                    sum++;
                }
            }
            mat[i][1] = sum;
            mat[i][0] = i;
            queue.add(mat[i]);
        }
        int[] result = new int[k];
        int index = 0;
        while (!queue.isEmpty() && index < k) {
            result[index++] = queue.poll()[0];
        }
        return result;
    }
}
