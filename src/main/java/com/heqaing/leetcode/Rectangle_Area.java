package com.heqaing.leetcode;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Rectangle_Area {
    public static void main(String args[]){
        int A=-1500000001,B=0,C=-1500000000,D=1,E=1500000000,F=0,G=1500000001,H=1;
        int rec1_area = (C-A)*(D-B);
        int rec2_area = (G-E)*(H-F);
        System.out.println(rec1_area+rec2_area);
        long x1 = Math.max(A,E);
        long x2 = Math.min(C,G);
        long y1 = Math.max(B,F);
        long y2 = Math.min(D,H);

        long x = x2-x1;
        long y = y2-y1;

        if(x<=0||y<=0){
            System.out.println(rec1_area+rec2_area);
        }else {
            System.out.println(rec1_area+rec2_area-x*y);
        }
    }
}
