package com.rookie.leetcode;

/**
 * Created by HeQiang on 2017-06-12 12:56.
 */
public class StringIterator {
    char[] charArr;
    int[] numArr;
    int position = -1;
    public StringIterator(String compressedString) {
        String[] nums = compressedString.split("\\D+");
        charArr = new char[nums.length-1];
        numArr = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            numArr[i-1] = Integer.valueOf(nums[i]);
        }
        char[] chars = compressedString.toCharArray();
        int k = 0;
        for (int i=0;i<chars.length;i++){
            if(chars[i]<'0'||chars[i]>'9'){
                charArr[k++] = chars[i];
            }
        }
        if(charArr.length!=0) position = 0;
    }

    public char next() {
        char next;
        if(position!=-1){
            next = charArr[position];
            numArr[position] = numArr[position]-1;
            if(numArr[position]==0){
                if(++position==charArr.length) position=-1;
            }
        }else {
            next = ' ';
        }
        return next;
    }

    public boolean hasNext() {
        return position!=-1;
    }
    public static void main(String[] args){
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        iterator.next(); // return 'L'
        iterator.next(); // return 'e'
        iterator.next(); // return 'e'
        iterator.next(); // return 't'
        iterator.next(); // return 'C'
        iterator.next(); // return 'o'
        iterator.next(); // return 'd'
        iterator.hasNext(); // return true
        iterator.next(); // return 'e'
        iterator.hasNext(); // return false
        iterator.next(); // return ' '
    }
}
