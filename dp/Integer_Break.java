/*
Similar to coin change. Consider 4, it can be break as 1+3, 2+2, 1+(1+2), 1+1+(1+1), (1+1)+2, (1+1)+(1+1)
Production of breaking into 2 integer is new result to a integer, 
but production of breakings into several integers should be calculated and recorded before.
Therefore, define array dp, compare precalculated result to new result(break into 2 integers) 
*/
class Solution {
    public int integerBreak(int n) {
        if (n<3) {
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for (int i=3; i<=n; i++) {
            for (int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i-j)*j, dp[i-j]*j));
            }
        }
        return dp[n];
    }
}