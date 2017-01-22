package com.heqaing.leetcode;


/**
 * Created by Administrator on 2016/11/3.
 */
public class Convert_a_Number_to_Hexadecimal {
    public static void main(String args[]){
        int num = Integer.MAX_VALUE/2;
        System.out.println(Integer.MAX_VALUE);
        long t1 = System.nanoTime();
        toHex(num);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }
    public static String toHex(int num) {
        char[] base = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        char[] result = new char[8];
        int count = 0;
        if(num>0){
            while(num!=0){
                count++;
                result[8-count] = base[num%16];
                num = num/16;
            }
            return String.valueOf(result,8-count,count);
        }else if(num<0){
            if(num==Integer.MIN_VALUE){
                return "80000000";
            }
            num = num*-1;
            for(int i=result.length-1;i>=0;i--){
                result[i] = base[base.length-num%16-1];
                num = num/16;
            }
            for (int i=result.length-1;i>=0;i--){
                if(result[i]=='f'){
                    result[i] = '0';
                }else {
                    if(result[i]=='9'){
                        result[i] = 'a';
                    }else {
                        result[i] = (char) (result[i]+1);
                    }
                    break;
                }
            }
            for(int i=0;i<result.length;i++){
                if(result[i]=='0'){
                    count++;
                }else {
                    break;
                }
            }
            return String.valueOf(result,count,8-count);
        }else{
            return "0";
        }
    }
}
