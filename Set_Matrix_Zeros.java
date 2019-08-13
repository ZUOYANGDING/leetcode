class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix==null) {
            return;
        }
        boolean row = false;
        boolean col = false;
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }
        for (int j=0; j<matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                row = true;
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[0][j]==0 || matrix[i][0]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        if (row) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}