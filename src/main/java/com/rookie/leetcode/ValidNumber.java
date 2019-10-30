package com.rookie.leetcode;

public class ValidNumber {

    public static void main(String[] args){
        ValidNumber question = new ValidNumber();
        boolean result = question.isNumber("-");
//        System.out.println(result);
    }

    public boolean isNumber(String s) {
        if(s==null){
            return false;
        }
        String str = s.trim();
        int len = str.length();
        if(len==0){
            return false;
        }
        if(len==1){
            return str.matches("[\\d]");
        }
        if(str.contains(".")){
            if(str.contains("e")){
                return str.matches("^[+|-]?[\\d]+[.][\\d]*e[+|\\-]?[\\d]+|[+|-]?[\\d]*[.][\\d]+e[+|\\-]?[\\d]+$");
            }else {
                return str.matches("^[+|\\-]?[\\d]+\\.|[+|\\-]?[\\d]*\\.[\\d]+$");
            }
        }else{
            return str.matches("^[+|\\-]?[\\d]*([\\d]e[+|\\-]?)?[\\d]+$");
        }
    }
}
