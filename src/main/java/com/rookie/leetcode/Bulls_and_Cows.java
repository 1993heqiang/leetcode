package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Bulls_and_Cows {
    public static void main(String args[]){
        String secret = "1807";
        String guess = "7810";//A完全对应，B位置不同
        long t1 = System.nanoTime();
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int Anum = 0;
        int Bnum = 0;
        for(int i=0;i<s.length;i++){
            if(s[i]==g[i]){
                Anum++;
                g[i] = ' ';
            }else {
                for(int j=0;j<g.length;j++){
                   if(g[j]==s[i]&&g[j]!=s[j]){
                       Bnum++;
                       g[j] = ' ';
                       break;
                   }
                }
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(""+Anum+"A"+Bnum+"B");
    }
}
