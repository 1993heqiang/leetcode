package com.rookie.leetcode;

import java.util.Arrays;

public class Construct_the_Rectangle {

	public static void main(String[] args) {
		int area = 3;
		long t1 = System.nanoTime();
		int[] ret = constructRectangle(area);
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(Arrays.toString(ret));
	}
	public static int[] constructRectangle(int area) {
		int a = (int)Math.sqrt(area);
		int[] ret = new int[2];
		while(area%a != 0){
            a--;
        }
		int b = area/a;
        ret[0] = b;
        ret[1] = a;
        return ret;
    }
}
