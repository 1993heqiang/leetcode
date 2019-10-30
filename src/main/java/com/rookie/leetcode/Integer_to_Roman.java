package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/11/24.
 */
public class Integer_to_Roman {
    public static void main(String args[]){
        int num = 11;
        long t1 = System.nanoTime();
        String ret = intToRoman(num);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static String intToRoman(int num) {
        char[] base = {'I','V','X','L','C','D','M'};
        int count = 0,position=0;
        char[] ret = new char[16];
        while (true){
            switch (num%10) {
                case 0:
                    break;
                case 1:
                    ret[position] = base[count];position+=1;
                    break;
                case 2:
                    ret[position+1] = base[count];ret[position] = base[count];position+=2;
                    break;
                case 3:
                    ret[position+2] = base[count];ret[position+1] = base[count];ret[position] = base[count];position+=3;
                    break;
                case 4:
                    ret[position+1] = base[count];ret[position] = base[count+1];position+=2;
                    break;
                case 5:
                    ret[position] = base[count+1];position+=1;
                    break;
                case 6:
                    ret[position+1] = base[count+1];ret[position] = base[count];position+=2;
                    break;
                case 7:
                    ret[position+2] = base[count+1];ret[position+1] = base[count];ret[position] = base[count];position+=3;
                    break;
                case 8:
                    ret[position+3] = base[count+1];ret[position+2] = base[count];ret[position+1] = base[count];ret[position] = base[count];position+=4;
                    break;
                case 9:
                    ret[position+1] = base[count];ret[position] = base[count+2];position+=2;
                    break;
            }
            num /= 10;
            if(num==0) break;
            count+=2;
        }
        char[] newRet = new char[position];
        for(int i=position-1;i>=0;i--){
            newRet[position-i-1] = ret[i];
        }
        return String.valueOf(newRet);
    }
}
