package com.rookie.leetcode;

import java.util.Arrays;

public class ImageSmoother {

    private static final int[] NUMS = {-1,0,1};

    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] result = imageSmoother.imageSmoother(input);
        System.out.println(Arrays.deepToString(result));
    }
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int rows = M.length;
        if (rows == 0) return new int[0][];
        int cols = M[0].length;

        int[][] result = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;
                for (int incR : NUMS) {
                    for (int incC : NUMS) {
                        if (isValid(row + incR, col + incC, rows, cols)) {
                            count++;
                            sum += M[row + incR][col + incC];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }

        return result;

    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
