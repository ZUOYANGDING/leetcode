/* n = a^2 + b^2 +...+ x^2
define dp[i] as the least number of perfect square numbers, therefore:
    dp[i] = min(dp[i], dp[i-x^2]+1) for all x<=sqrt(i)
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}