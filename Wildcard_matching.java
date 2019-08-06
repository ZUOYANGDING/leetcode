class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int j=1; j<l2+1; j++) {
            if (p.charAt(j-1)=='*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int j=1; j<l2+1; j++) {
            for (int i=1; i<l1+1; i++) {
                if (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    // dp[i][j] only depends on the result before '*'.
                    // '*' can be represent empty sequence (dp[i][j-1]) or any sequence
                    // after the matching part after s[i-1] (dp[i-1][j])
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]); 
                }
            }
        }
        return dp[l1][l2];
    }
}