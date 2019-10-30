package com.rookie.leetcode;

public class Base7 {

	public static void main(String[] args) {
		int num = 10000000;
		long t1 = System.nanoTime();
		String ret = convertToBase7(num);
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(ret);
	}
	public static String convertToBase7(int num) {
		char[] digits = {'0','1','2','3','4','5','6'};
		char buf[] = new char[33];
        boolean negative = (num < 0);
        int charPos = 32;

        if (!negative) {
        	num = -num;
        }

        while (num <= -7) {
            buf[charPos--] = digits[-(num % 7)];
            num = num / 7;
        }
        buf[charPos] = digits[-num];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

}
