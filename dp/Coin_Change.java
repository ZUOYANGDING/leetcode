/*  idea: knapsack problem
    Algorithm: define dp[i][j] = use first i coins to build exact j amount
                dp[i][j] = min(dp[i][j], dp[i-1][j-k*coin_i]+k)
                         = min(dp[i][j], dp[i][j-coin_i]+1) 
*/ 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return (dp[amount]==amount+1 ? -1 : dp[amount]);
    }
}