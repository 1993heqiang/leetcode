package com.rookie.leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/24.
 */
public class Excel_Sheet_Column_Title {
    public static void main(String[] args){
        int n =52;
        String ret = "";
        while(n/26>0){
            if(n/26==1&&n%26==0){
                break;
            }else if(n%26==0){
                ret='Z'+ret;
                n=n/26-1;
            }else{
                ret=(char)('A'+n%26-1)+ret;
                n/=26;
            }
        }
        ret=(char)('A'+n-1)+ret;
        System.out.println(ret);
    }
}
