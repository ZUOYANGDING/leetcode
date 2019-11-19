// Set an dp array to record best choice from 0 to i. If dp[i-1] < 0 means the best choice should be start
// from i, else best choice may include the pre best choice.
// EX:
// NUMS:  -2 1 -3 4 -1 2 1 -5 4
// DP:    -2 1 -2 4  3 5 6  1 5

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] +dp[i-1];
            }
        }
        int re = dp[0];
        for (int i=0; i<nums.length; i++) {
            if (dp[i] > re) {
                re = dp[i];
            }
        }
        return re;
    }
}