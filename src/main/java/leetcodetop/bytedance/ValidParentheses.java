package leetcodetop.bytedance;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len == 0 || len % 2 == 1 || arr[0] == ')' || arr[0] == ']' || arr[0] == '}') {
            return false;
        } else {
            List<Character> temp = new ArrayList<>();
            char curChar;
            char lastChar;
            int lastIndex;
            for (char c : arr) {
                curChar = c;
                if (curChar == '(' || curChar == '[' || curChar == '{') {
                    temp.add(curChar);
                } else {
                    lastIndex = temp.size() - 1;
                    lastChar = temp.get(lastIndex);
                    if (curChar == ')') {
                        if (lastChar == '(') {
                            temp.remove(lastIndex);
                        } else {
                            return false;
                        }
                    } else if (curChar == ']') {
                        if (lastChar == '[') {
                            temp.remove(lastIndex);
                        } else {
                            return false;
                        }
                    } else if (curChar == '}') {
                        if (lastChar == '{') {
                            temp.remove(lastIndex);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return temp.size() <= 0;
        }
    }
}
