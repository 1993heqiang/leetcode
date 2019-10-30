package com.rookie.leetcode;


/**
 * Created by Administrator on 2016/11/30.
 */
public class Maximum_Product_of_Word_Lengths {
    public static void main(String args[]){
        String[] words = {"bc","d"};
        long t1 = System.nanoTime();
        int ret = maxProduct(words);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int maxProduct(String[] words) {
        int len = words.length;
        int [] bitmask = new int[len];
        for(int i=0;i<len;i++){
            for(int j = 0; j < words[i].length(); j++){
                bitmask[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        int max = 0;
        int temp;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if((bitmask[i] & bitmask[j]) == 0){
                    temp = words[i].length() * words[j].length();
                    max = temp>max?temp:max;
                }
            }
        }

        return max;
    }
}
