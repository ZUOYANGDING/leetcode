// Same idea as house rober. To transfer the original array to an house rober problem array:
// example: nums = [2, 2, 3, 3, 3, 4, 6] -> reduce=[0, 0, 2*2, 3*3, 4, 0, 6]. reduce[5]==0, means
// means 5 is not in the original array. If we choose i=5 and i=3 instead of i=4, which means
// reduce[3]>reduce[4], based on the dp function we have dp[4] = max(reduce[4]+dp[2], dp[3]), which means
// dp[4]+dp[2] > dp[3]. However, dp[3]+dp[5]==0 and dp[2]!=0, which is contrust to dp[4]+dp[2] > dp[3].
// Therefore, an element which 0 in the reduce array won't have influence on the final result

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] reduce = new int[max+1];
        for (int i : nums) {
            reduce[i] += i;
        }
        return help(reduce);
    }
    
    public int help(int[] reduce) {
        int[] dp = new int[reduce.length];
        dp[0] = reduce[0];
        dp[1] = Math.max(reduce[0], reduce[1]);
        for (int i=2; i<reduce.length; i++) {
            dp[i] = Math.max(dp[i-1], reduce[i]+dp[i-2]);
        }
        return dp[reduce.length-1];
    }
}