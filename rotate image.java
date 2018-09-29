//clockwise roatation: first reverse up to down, then swap the symmetric elements
//counter clockwise roatation: first reverse left to right , then swap the symmetric elements
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //reverse up to down
        for (int i=0; i<row/2; i++){
            for (int j=0; j<col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-i-1][j];
                matrix[row-i-1][j] = temp;
            }
        }
        //swap the symmetric elements
        for (int i=0; i<row; i++){
            for (int j=i; j<col; j++){
                if (i == j){
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}