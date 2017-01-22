package com.heqaing.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/9/1.
 */
public class Valid_Parentheses {
    public static void main(String args[]){
        long t1 = System.nanoTime();
        String s = "()[]{}({})[][][(){}]([{([])}])";
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean flag = true;
        if(len==0||len%2==1||arr[0]==')'||arr[0]==']'||arr[0]=='}'){
            System.out.println(false);
        }else{
            List<Character> temp = new ArrayList<Character>();
            char curChar;
            char lastChar;
            int lastIndex;
            for(int i=0;i<len;i++){
                curChar = arr[i];
                if(curChar=='('||curChar=='['||curChar=='{'){
                    temp.add(curChar);
                }else{
                    lastIndex = temp.size()-1;
                    lastChar = temp.get(lastIndex);
                    if(curChar==')'){
                        if(lastChar=='('){
                            temp.remove(lastIndex);
                        }else{
                            flag = false;
                            break;
                        }
                    }else if(curChar==']'){
                        if(lastChar=='['){
                            temp.remove(lastIndex);
                        }else{
                            flag = false;
                            break;
                        }
                    }else if(curChar=='}'){
                        if(lastChar=='{'){
                            temp.remove(lastIndex);
                        }else{
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(temp.size()!=0) flag = false;
        }
        long t2 = System.nanoTime();
        System.out.println(flag);
        System.out.println(t2-t1);
    }
}
