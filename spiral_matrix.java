class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> solution= new ArrayList<>();
        int indexR = 0;
        int indexC = 0;
        int row = (matrix.length)>0 ? matrix.length : 0;
        if (!(row>0)) {
            return solution;
        }
        int col = matrix[0].length;
        while (indexR<=row-1 && indexC<=col-1) {
            for (int i=indexC; i<col; i++) {
                if (indexR<=row-1 && indexC<=col-1) {
                    solution.add(matrix[indexR][i]);
                }
            }
            indexR++;
            for (int i=indexR; i<row; i++) {
                if (indexR<=row-1 && indexC<=col-1) {
                    solution.add(matrix[i][col-1]);
                }
            }
            col--;
            for (int i=col-1; i>=indexC; i--) {
                if (indexR<=row-1 && indexC<=col-1) {
                    solution.add(matrix[row-1][i]);
                }
            }
            row--;
            for (int i=row-1; i>=indexR; i--) {
                if (indexR<=row-1 && indexC<=col-1) {
                    solution.add(matrix[i][indexC]);
                }    
            }
            indexC++;
        }
        return solution;
    }
}