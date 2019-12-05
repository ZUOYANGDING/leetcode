/*
Idea:
    define dp[i][0] as ways to build a square have i columns, dp[i][1] as ways to build a square have i
    columns but the ith column only have one cell on top, and dp[i-1][2] as ways to build a square have i
    columns but the ith column only have one cell on button.
    Therefore:
        dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-1][1] + dp[i-1][2]
        xxxx        xxx   x      xx   xx     xxx    x     xx      xx
        xxxx        xxx + x      xx + yy     xx  + xx     xxx  +   x

        dp[i][1] = dp[i-2][0] + dp[i-1][2]
        xxxx        xx   xx      xx    xx
        xxx         xx + x       xxx + 

        dp[i-1][2] = dp[i-2][0] + dp[i-1][1]
        xxx          xx   x       xxx
        xxxx         xx + xx      xx  + xx

    Since the dp[i-1][1] and dp[i-1][2] is symetric conditions, we can have:
        dp[i][0] = dp[i-1][0] + dp[i-2][0] + 2 * dp[i-1][1]
        dp[i][1] = dp[i-2][0] + dp[i-1][1]
*/

class Solution {
    public int numTilings(int N) {
        if (N == 1) {
            return 1;
        }
        long [][] dp = new long[N+1][2];
        long mod = 1000000007;
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i=2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1]) % mod;
            dp[i][1] = (dp[i-2][0] + dp[i-1][1]) % mod;
        }
        return (int) dp[N][0];
    }
}