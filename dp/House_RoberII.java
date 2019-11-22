// Similar idea as house rober. Since last and first house adjecent to each other, we only can choose first
// or last one, not both. By this way, use the Problem:House Rober's algorithm, check houses[0, n-1], then
// check houses[1,n]

class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp_0 = new int[nums.length];
        int[] dp_1 = new int[nums.length];
        return Math.max(help(nums, dp_0, 0, nums.length-1), 
                        help(nums, dp_1, 1, nums.length));
    }
    
    public int help(int[] nums, int[] dp, int start, int end) {
        for (int i=start; i<end; i++) {
            if (i==start) {
                dp[i] = nums[i];
            } else if (i==start+1) {
                dp[i] = Math.max(nums[i], nums[i-1]);
            } else {
                dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
            }
        }
        return dp[end-1];
    }
}