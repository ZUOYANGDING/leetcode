class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> re = new LinkedList<>();
        if (nums==null || nums.length==0) {
            return re;
        }
        Arrays.sort(nums);
        int start = 0;
        int max_length = 0;
        int size = nums.length;
        // dp[i] store the max length of subset at index i
        int[] dp = new int[size];
        // pre[i] store the index of previous element in nums that can divided by nums[i]
        int[] pre = new int[size];
        for (int i=size-1; i>=0; i--) {
            for (int j=i; j<size; j++) {
                if (nums[j]%nums[i]==0 && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                    pre[i] = j;
                    if (max_length < dp[i]) {
                        max_length = dp[i];
                        start = i;
                    }
                }
            }
        }
        for (int i=0; i<max_length; i++) {
            re.add(nums[start]);
            start = pre[start];
        }
        return re;
    }
}