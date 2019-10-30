package com.rookie.leetcode;


/**
 * Created by Administrator on 2016/8/25.
 */
public class Valid_Palindrome {
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        boolean flag = true;
        char c1,c2;
        for(int i=0;i<s.length();i++){
            c1 = s.charAt(i);
            if(c1!=32&&c1!=9){
                flag = false;
                break;
            }
        }
        if(flag) System.out.println(flag);
        if(!flag){
            flag = true;
            int left = 0;
            int right = s.length()-1;
            while(right>=left){
                c1 = s.charAt(left);
                if(!(('0'<=c1&&c1<='9')||('a'<=c1&&c1<='z')||('A'<=c1&&c1<='Z'))){
                    left++;
                    continue;
                }
                c2 = s.charAt(right);
                if(!(('0'<=c2&&c2<='9')||('a'<=c2&&c2<='z')||('A'<=c2&&c2<='Z'))){
                    right--;
                    continue;
                }
                if(c1>='A'&&c1<='Z'){
                    c1 = (char) (c1+32);
                }
                if(c2>='A'&&c2<='Z'){
                    c2 = (char) (c2+32);
                }
                if(c1!=c2){
                    flag = false;
                    break;
                }
                left++;
                right--;
            }
            System.out.println(flag);
        }

    }
}
