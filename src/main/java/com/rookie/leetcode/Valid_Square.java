package com.rookie.leetcode;

public class Valid_Square {
    public static void main(String[] args) {
        Valid_Square instance = new Valid_Square();
        boolean result = instance.validSquare(new int[]{0, 0},
                new int[]{5, 0}, new int[]{5, 4}, new int[]{0, 4});
        System.out.println(result);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int distance12 = distance(p1, p2);
        int distance23 = distance(p2, p3);
        int distance13 = distance(p1, p3);
        if (distance12 == 0 || distance13 == 0 || distance23 == 0) {
            return false;
        }
        if (distance12 == distance23 + distance13 && distance23 == distance13) {
            return isEquilateralRightTriangle(p4, p1, p2, distance12);
        } else if (distance13 == distance12 + distance23 && distance12 == distance23) {
            return isEquilateralRightTriangle(p4, p1, p3, distance13);
        } else if (distance23 == distance12 + distance13 && distance12 == distance13) {
            return isEquilateralRightTriangle(p4, p2, p3, distance23);
        }
        return false;
    }

    private boolean isEquilateralRightTriangle(int[] p1, int[] p2, int[] p3, int target) {
        int distance12 = distance(p1, p2);
        int distance13 = distance(p1, p3);
        return distance12 == distance13 && target == distance12 + distance13;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
