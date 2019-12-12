// Unique version of Maximal_Rectangle
/*
    regard every position as the possible most left upper corner of a square, then check. Algorithm:
        for (i from 1 to row):
            for (j from 1 to col):
                for (k from Min(row-i+1, col-j+1) to 1) :
                    check if there is a sqaure
    There are duplicate computing:
        from position[i][j], if we check matrix[i+n][j+n] we need to compute matrix[i+1][j+1] to 
        maxtrix[i+n][j+n].
    
    To decrease the time complexity from O(n^5) to O(n^3), compute and record the sum in rectangle [0:row, 0:col]
    sum[x][y] = sum[x-1][y] + sum[x][y-1] + matrix[x][y] - sum[x-1][y-1]
    
    Then the most inner loop check's time complexity can be decreased to O(1). The sum of number in square
    (start at [i, j] as the most left and upper corner) is:
        area = sum[i+k-1][j+k-1]-sum[i+k-1][j-1]-sum[i-1][j+k-1]+sum[i-1][j-1]
        since sum[i][j] means the sum of numbers in rectangle [0:i, 0:j].
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row+1][col+1];
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                sum[i][j] = (matrix[i-1][j-1]-'0') + 
                    sum[i-1][j] + 
                    sum[i][j-1] - 
                    sum[i-1][j-1];
            }
        }
        
        int re = 0;
        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                for (int k=Math.min(row-i+1, col-j+1); k>0; k--) {
                    int square = sum[i+k-1][j+k-1] -
                                sum[i+k-1][j-1] -
                                sum[i-1][j+k-1] +
                                sum[i-1][j-1];
                    if (square == k*k) {
                        re = Math.max(square, re);
                        break;
                    }
                }
            }
        }
        return re;
    }
}


// O(N^2)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int re = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j]=='0') {
                    continue;
                } else {
                    if (i==0 || j==0) {
                        dp[i][j] = matrix[i][j]-'0';
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], 
                                            Math.min(dp[i][j-1],
                                           dp[i-1][j-1])) + 1;
                    }
                    re = Math.max(re, dp[i][j]*dp[i][j]);
                }
            }
        }
        return re;
        
       
    }
}