package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/8/27.
 */
public class lengthOfLastWord {
    public static void main(String[] args){
        String s = "fkdsjf fsdf fdsaf fsadf  ";
        int len = s.length();
        int ret = 0;
        boolean flag = false;
        if(len==0){

        }else{
            for(int i=len-1;i>=0;i--){
                if(!flag){
                    if(s.charAt(i)!=' '){
                        flag = true;
                        ret++;
                    }
                    continue;
                }
                if(flag&&s.charAt(i)==' '){
                    break;
                }
                ret++;

            }
        }
        System.out.println(ret);
    }

}
