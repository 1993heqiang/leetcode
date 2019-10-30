package com.rookie.leetcode;

public class Detect_Capital {

	public static void main(String[] args) {
		String word = "afdsfadsfds";
		long t1 = System.nanoTime();
		boolean ret = detectCapitalUse(word);
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(ret);
	}
	public static boolean detectCapitalUse(String word) {
		char[] wordArr = word.toCharArray();
        int wordLen = wordArr.length;
        if(wordLen==0) return false;
        if(wordLen==1) return true;
        if('a'<=wordArr[0]){
        	for(int i=1;i<wordLen;i++){
        		if(wordArr[i]<'a') return false;
        	}
        }else{
        	if('a'<=wordArr[1]){
        		for(int i=2;i<wordLen;i++){
        			if(wordArr[i]<'a') return false;
        		}
        	}else{
        		for(int i=2;i<wordLen;i++){
        			if('a'<=wordArr[i]) return false;
        		}
        	}
        }
        return true;
    }
}
