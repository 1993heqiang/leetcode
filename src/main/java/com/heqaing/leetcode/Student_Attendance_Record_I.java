package com.heqaing.leetcode;

/**
 * Created by HeQiang on 2017/6/4.
 */
public class Student_Attendance_Record_I {
    public static void main(String[] args){
        String s = "PPALLP";
        long t1 = System.nanoTime();
        boolean result = checkRecord(s);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(result);
    }
    public static boolean checkRecord(String s) {
        char[] charArr = s.toCharArray();
        int countA = 0;
        int continuousL = 0;
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]=='A'){
                countA++;
                continuousL = 0;
            }else if(charArr[i]=='L'){
                continuousL++;
            }else {
                continuousL = 0;
            }
            if(countA>1||continuousL>2){
                return false;
            }
        }
        return true;
    }
}
