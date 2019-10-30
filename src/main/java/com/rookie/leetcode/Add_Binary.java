package com.rookie.leetcode;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Add_Binary {
    public static void main(String[] args){
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        long t1 = System.nanoTime();
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        char[] temp;
        if(arr1.length<arr2.length){
            temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        temp = new char[len1+1];
        int len3 = temp.length;
        for(int i=1;i<=(len1-len2);i++){
            temp[i] = arr1[i-1];
        }

        int k;
        for(int i=0;i<len2;i++) {
            if (arr2[len2 - i - 1] == '1' && arr1[len1 - i - 1] == '1') {
                k = 2;
                while (true) {
                    if (temp[len3 - i - k] == '0' || temp[len3 - i - k] == 0) {
                        temp[len3 - i - k] = '1';
                        break;
                    } else {
                        temp[len3 - i - k] = '0';
                        k++;
                    }
                }
            } else if (arr2[len2 - i - 1] == '1' || arr1[len1 - i - 1] == '1') {
                if (temp[len3 - i - 1] == '1') {
                    temp[len3 - i - 1] = '0';
                    k = 2;
                    while (true) {
                        if (temp[len3 - i - k] == '0' || temp[len3 - i - k] == 0) {
                            temp[len3 - i - k] = '1';
                            break;
                        } else {
                            temp[len3 - i - k] = '0';
                            k++;
                        }
                    }
                } else {
                    temp[len3 - i - 1] = '1';
                }
            }
        }
        for(int i=1;i<len3;i++){
            if(temp[i]==0){
                temp[i] = '0';
            }
        }
        String ret = String.valueOf(temp);
        long t2 = System.nanoTime();
        System.out.println(temp[0]=='1'?ret:ret.substring(1));
        System.out.println(t2-t1);
    }
}
