/*
Maintain dp[l1+1][l2+1], add empty space before word1 and word2. if word1[i]==word2[j], means
dp[i][j] = dp[i-1][j-1]. Otherwise, choices are replace/delete/insert, replace (dp[i][j] = 1 + dp[i-1][j-1]),
means word1[i-1]==word2[j-1]; delete the current char in word1 (dp[i][j]=1+dp[i-1][j]) 
means word1[i-1] = word2[j]; insert a char=word2[j] at index i in word1 (dp[i][j] = 1+dp[i][j-1])
means word1[i] = word2[j-1].
*/
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1==null && word2==null) {
            return 0;
        } else if (word1==null && word2!=null) {
            return word2.length();
        } else if (word1!=null && word2==null) {
            return word1.length();
        }
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i=1; i<=l1; i++) {
            if (word1.charAt(i-1) == ' ') {
                dp[i][0] = dp[i-1][0];
            } else {
                dp[i][0] = dp[i-1][0] + 1;
            }
        }
        for (int j=1; j<=l2; j++) {
            if (word2.charAt(j-1) == ' ') {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = dp[0][j-1] + 1;
            }
        }
        for (int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}