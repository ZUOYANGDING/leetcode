// similar as paint house problem. However, we need to record the 1st min and 2nd min of the previous
// result, instead of go over the whole previous result. Therefore, when the 1st min's color in previous
// result is same as j, we add the 2nd min to dp[i][j], since only the consecutive house cannot be paint
// as the same color.
// In this way, the time complexity is O(nk), better than O(nk^2)
class Solution {
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0) {
            return 0;
        }
        int[][] dp = costs;
        int min1 = -1, min2 = -1;
        for (int i=0; i<costs.length; i++) {
            int pre_min1 = min1, pre_min2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j=0; j<costs[0].length; j++) {
                if (j==pre_min1) {
                    dp[i][j] += (pre_min2==-1 ? 0 : dp[i-1][pre_min2]);
                } else {
                    dp[i][j] += (pre_min1==-1 ? 0 : dp[i-1][pre_min1]);
                }
                if (min1==-1 || dp[i][j]<dp[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2==-1 || dp[i][j]<dp[i][min2]) {
                    min2 = j;
                }
            }
        }
        return dp[costs.length-1][min1];
    }
}