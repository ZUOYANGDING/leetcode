// For house i, have 2 choices: 1) rob it, which means skip at least prev house; 2) skip it.
// Therefore, for i>2, we have dp[i] = max(dp[i-2]+nums[2], dp[i-1])

class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[1], nums[0]);
            for (int i=2; i<nums.length; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
            return dp[nums.length-1];
        }
    }
}