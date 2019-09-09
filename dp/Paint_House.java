// apply a 2-dim matrix to record the lowest cost until ith house when it's painted by red, blue
// and green.
class Solution {
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0) {
            return 0;
        }
        int row = costs.length;
        int[][] dp = new int[row][3];
        for (int j=0; j<3; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i=1; i<row; i++) {
            for (int j=0; j<3; j++) {
                dp[i][j] = costs[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }
        return Math.min(dp[row-1][0], Math.min(dp[row-1][1], dp[row-1][2]));
    }
}

