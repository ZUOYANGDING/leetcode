class Solution {
    private int num;
    private int[][] res;
    public int[][] generateMatrix(int n) {
        res = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = n-1;
        num = 1;
        while (num <= n*n) {
            insertNumber(top, left, right, top);
            top++;
            insertNumber(top, right, right, bottom);
            right--;
            insertNumberII(bottom, left, right, bottom);
            bottom--;
            insertNumberII(top, left, left, bottom);
            left++;
        }
        return res;
    }
    
    public void insertNumber(int top, int left, int right, int bottom) {
        for (int i=top; i<=bottom; i++) {
            for (int j=left; j<=right; j++) {
                res[i][j] = num;
                num++;
            }
        }
    }
    
    public void insertNumberII(int top, int left, int right, int bottom) {
        for (int i=bottom; i>=top; i--) {
            for (int j=right; j>=left; j--) {
                res[i][j] = num;
                num++;
            }
        }
    }
    
}