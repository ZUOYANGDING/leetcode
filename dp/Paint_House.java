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
                int min = Integer.MAX_VALUE;
                for (int k=0; k<3; k++) {
                    if (k==j) {
                        continue;
                    } else {
                        min = Math.min(min, dp[i-1][k]);
                    }
                }
                dp[i][j] = costs[i][j] + min;
            }
        }
        return Math.min(dp[row-1][0], Math.min(dp[row-1][1], dp[row-1][2]));
    }
}