package com.heqaing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keyboard_Row {

	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		long t1 = System.nanoTime();
		String[] ret = findWords(words);
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(Arrays.toString(ret));

	}
	public static String[] findWords(String[] words) {
		String[] mask = new String[words.length];
		int index = 0;
		for(int i=0;i<words.length;i++){
			if(contain(words[i])) {
				mask[index++] = words[i];
			}
		}
		return Arrays.copyOfRange(mask, 0, index);
    }
	public static boolean contain(String word){
		int[] keyboard = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
		char[] arr = word.toLowerCase().toCharArray();
		int base = keyboard[arr[0]-'a'];
		for(int i=1;i<arr.length;i++){
			if(keyboard[arr[i]-'a']!=base) return false;
		}
		return true;
	}
}
