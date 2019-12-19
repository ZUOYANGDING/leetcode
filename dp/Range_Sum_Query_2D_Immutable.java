// Same idea as maximal_square.java

class NumMatrix {
    private int[][] sum;
    private int row;
    private int col;
    private boolean check;
    public NumMatrix(int[][] matrix) {
        check = checkMatrix(matrix);
        if (check) {
            row = matrix.length;
            col = matrix[0].length;
            sum = new int[row+1][col+1];
            for (int i=1; i<=row; i++) {
                for (int j=1; j<=col; j++) {
                    sum[i][j] = sum[i-1][j] + 
                                sum[i][j-1] + 
                                matrix[i-1][j-1] -
                                sum[i-1][j-1];

                }
            }
        }
        // for (int i=0; i<=row; i++) {
        //     System.out.println(Arrays.toString(sum[i]));
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1<0 || row<0 || col1<0 || col2<0 || row1>=row || row2>=row || col1>=col
           || col2>=col || !check) {
            return 0;
        }
        return sum[row2+1][col2+1] - 
                sum[row2+1][col1] - 
                sum[row1][col2+1] + 
                sum[row1][col1];
    }
    
    boolean checkMatrix(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */