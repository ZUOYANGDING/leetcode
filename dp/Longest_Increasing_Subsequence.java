/*
Idea: 
        



*/


// recursive way
class Solution {
    
    private int[] dp;
    
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        
        dp = new int[nums.length];
        int re = 0;
        for (int i=0; i<nums.length; i++) {
            re = Math.max(re, help(nums, i));
        }
        return re;
    }
    
    private int help(int[] nums, int index) {
        if (index==0) {
            return 1;
        }
        if (dp[index]>0) {
            return dp[index];
        }
        int re = 1;
        for (int i=0; i<index; i++) {
            if (nums[i] < nums[index]) {
                re = Math.max(re, help(nums, i)+1);
            }
        }
        dp[index] = re;
        return dp[index];
    }
}

// iterative way
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }    
            }
        }
        
        int re = dp[0];
        for (int i=0; i<nums.length; i++) {
            re = Math.max(re, dp[i]);
        }
        return re+1;
    }
}