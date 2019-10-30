package com.rookie.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/10.
 */
public class Queue_Reconstruction_by_Height {
    public static void main(String args[]){
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        long t1 = System.nanoTime();
        int[][] ret = reconstructQueue(people);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        for(int i=0;i<people.length;i++){
            System.out.print(Arrays.toString(ret[i])+",");
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[people[i][1]]++;
        }
        int[][] result = new int[len][2];
        int temp;
        int count = 0;
        for(int i=0;i<len;i++){
            if(arr[i]!=0){
                for(int j=0;j<len;j++){
                    if(people[j][1]==i){
                        temp = people[j][1];
                        for(int k=0;k<=count;k++){
                            if(k==count){
                                result[k][0] = people[j][0];
                                result[k][1] = i;
                                count++;
                                break;
                            }
                            if(people[j][0]<=result[k][0]&&temp==0){
                                for(int p=count-1;p>=k;p--){
                                    result[p+1][0] = result[p][0];
                                    result[p+1][1] = result[p][1];
                                }
                                result[k][0] = people[j][0];
                                result[k][1] = i;
                                count++;
                                break;
                            }else if(people[j][0]<=result[k][0]&&temp!=0) {
                                temp--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
