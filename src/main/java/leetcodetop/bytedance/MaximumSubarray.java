package leetcodetop.bytedance;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0&&nums[i]>sum){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}
