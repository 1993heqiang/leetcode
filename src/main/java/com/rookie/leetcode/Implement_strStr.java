package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Implement_strStr {
    public static void main(String[] args){
        String haystack = "ehoiuhvb84f98wujgnhvgju098u092f9jugv9i40943tr09ju9gj4u3qt09[qu4hjt8gu493tq04ujg3iuq94ug094ugju90u9u439gu";
        String needle = "9gu";
        int len1 = haystack.length();
        int len2 = needle.length();
        long t1 = System.nanoTime();
        int index = -1;
        if(len2==0){
            System.out.println(0);
        }else{
            boolean flag;
            for(int i=0;i<=len1-len2;i++){
                if(haystack.charAt(i)==needle.charAt(0)){
                    flag = true;
                    for(int j=1;j<len2;j++){
                        if(haystack.charAt(i+j)!=needle.charAt(j)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        index = i;
                        break;
                    }
                }
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(index);
    }
}
