package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/8/23.
 */
public class Palindrome_Number {
    public static void main(String[] args){
        Palindrome_Number pn = new Palindrome_Number();
        System.out.println(pn.isPalindrome(101));
    }
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }else if(x<0||x%10==0){
            return false;
        }else{
            int count = 1;
            int temp = x;
            while((temp/=10)>0) count++;
            temp = x;
            int temp1 = x;
            for(int j=0;j<count/2;j++){
                if((temp%10)!=(temp1/(int)Math.pow(10, count-j-1))){
                    return false;
                }
                temp = temp/10;
                temp1 = temp1%((int)(Math.pow(10, count-j-1)));
            }
            return true;
        }
    }
}
