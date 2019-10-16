class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        if (grid.length == 0) {
            return res;
        }
        int r = grid.length, l = grid[0].length;
        int[][] v1 = new int[r][l];
        int[][] v2 = new int[r][l];
        int[][] v3 = new int[r][l];
        int[][] v4 = new int[r][l];
        for (int i=0; i<r; i++) {
            for (int j=0; j<l; j++) {
                int count = (j==0 || grid[i][j]=='W') ? 0 : v1[i][j-1];
                v1[i][j] = (grid[i][j]=='E') ? count+1 : count;
            }
            for (int j=l-1; j>=0; j--) {
                int count = (j==l-1 || grid[i][j]=='W') ? 0 : v2[i][j+1];
                v2[i][j] = (grid[i][j]=='E') ? count+1 : count;
            }
        }
        for (int j=0; j<l; j++) {
            for (int i=0; i<r; i++) {
                int count = (i==0 || grid[i][j]=='W') ? 0 : v3[i-1][j];
                v3[i][j] = (grid[i][j]=='E') ? count+1 : count;
            }
            for (int i=r-1; i>=0; i--) {
                int count = (i==r-1 || grid[i][j]=='W') ? 0 : v4[i+1][j];
                v4[i][j] = (grid[i][j]=='E') ? count+1 : count;
            }
        }
        for (int i=0; i<r; i++) {
            for (int j=0; j<l; j++) {
                if (grid[i][j]=='0') {
                   res = Math.max(res, v1[i][j]+v2[i][j]+v3[i][j]+v4[i][j]); 
                }
            }
        }
        return res;
    }
}