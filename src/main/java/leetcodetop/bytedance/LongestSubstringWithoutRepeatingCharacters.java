package leetcodetop.bytedance;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters instance =
                new LongestSubstringWithoutRepeatingCharacters();
        int result = instance.lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int len = s.length();
        List<Character> sub = new ArrayList<>();
        if (len == 0) {
            return maxLen;
        }
        char[] sArr = s.toCharArray();
        int start = 0;
        int index = 0;
        sub.add(sArr[index]);
        char cur;
        int temp;
        while (++index < len) {
            cur = sArr[index];
            if ((temp = findElement(sub, cur, start)) != -1) {
                maxLen = Math.max(maxLen, index - start);
                start = temp + 1;
            }
            sub.add(cur);
        }
        if (start < len) {
            maxLen = Math.max(maxLen, len - start);
        }
        return maxLen;
    }
    private int findElement(List<Character> list, char target, int bound) {
        for (int i = list.size() - 1; i >= bound; i--) {
            if (list.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
}
