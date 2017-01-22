package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/11/2.
 */
public class Add_Strings {
    public static void main(String args[]){
        //0~9 48~57
        String num1 = "123426342647632946194693246914";
        String num2 = "9987069800687078708687098707070";
        long t1 = System.nanoTime();
        String sum = addStrings(num1,num2);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(sum);

    }
    public static String addStrings(String num1, String num2) {
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        char[] minArr,maxArr;
        if(num1Arr.length>num2Arr.length){
            minArr = num2Arr;
            maxArr = num1Arr;
        }else {
            minArr = num1Arr;
            maxArr = num2Arr;
        }
        int minLen = minArr.length;
        int maxLen = maxArr.length;
        char[] result = new char[maxLen+1];
        int resultLen = maxLen+1;
        int flag = 0;
        int temp;
        for(int i=0;i<maxLen;i++){
            if(i<minLen){
                temp = (minArr[minLen-1-i]+maxArr[maxLen-1-i]-48*2+flag);
            }else {
                temp = maxArr[maxLen-1-i]-48+flag;
            }
            result[resultLen-1-i] = (char)(temp%10+48);
            if(temp>9){
                flag = 1;
            }else {
                flag = 0;
            }
        }
        result[0] = (char)(flag+48);
        return flag==0?String.valueOf(result,1,resultLen-1):String.valueOf(result);
    }

}
