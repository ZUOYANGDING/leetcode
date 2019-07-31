/*
Solve by dp;
There are two situations: s[i] = p[i] || p[i]=='.', s[i] = '*'. For the first one, if preceding parts
of s and p are matching, set the position as true, else still false (since dp depends on previous consequence).
For second one, '*' and it's preceding elements can be regarded as empty or repeated of preceding element.
If preceding part of the previous of previous elements of s and p are matching, this pattern can be regarded as empty.
If not, check if current char of string equals the char preceding * in pattern and dp at that position.
https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
*/
class Solution {
    public boolean isMatch(String s, String p) {
        if (p==null) {
            return (s==null);
        }
        int l1 = s.length();
        int l2 = p.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int i=2; i<l2+1; i++) {
            if (p.charAt(i-1)=='*' && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }
        for (int j=1; j<l2+1; j++) {
            for (int i=1; i<l1+1; i++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
//                     here p start as * is meaningless, therefore, no risk for Index outofbound
                    if (dp[i][j-2] ||  ((s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && 
                                       dp[i-1][j])) {
                        dp[i][j] = true;
                    } 
                }
            }
        }
        return dp[l1][l2];
    }
}