package leetcodetop.bytedance;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                int[] result = new int[2];
                result[1] = i;
                for (int j = 0; j < i; j++) {
                    if (nums[j] == target - nums[i]) {
                        result[0] = j;
                        return result;
                    }
                }
            } else {
                set.add(nums[i]);
            }
        }
        return null;
    }
}
