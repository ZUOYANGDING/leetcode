/*binary search row first, then binary search col. BAD!!! */

class Solution {
    private int[][] m;
    private int row;
    private int col;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        row = matrix.length-1;
        col = matrix[0].length-1;
        m = matrix;
        row = findRow(0, row/2, row, target);
        if (row == -1) {
            System.out.println("here");
            return false;
        }
        col = findCol(0, col/2, col, target, row);
        if (col != -1) {
            return true;
        } else {
            System.out.println(row);
            return false;
        }
        
    }
    
    public int findRow(int begin, int mid, int end, int target) {
        if (begin==end) {
            if (target>=m[begin][0] && target<=m[begin][col]) {
                return begin;
            } else {
                return -1;
            }
        } else {
            if (target >= m[begin][0] && target<=m[mid][col]) {
                end = mid;
                mid = (begin + end) / 2;
                return findRow(begin, mid, end, target);
            } else if (target > m[mid][col] && target<=m[end][col]) {
                begin = mid + 1;
                mid = (begin + end) / 2;
                return findRow(begin, mid, end, target);
            } else {
                return -1;
            }
        }
    }
    
    public int findCol(int begin, int mid, int end, int target, int index) {
        if (begin==end) {
            if (target==m[index][begin]) {
                return begin;
            } else {
                return -1;
            }
        } else {
            if (target > m[index][mid]) {
                begin = mid + 1;
                mid = (begin + end) / 2;
                return findCol(begin, mid, end, target, index);
            } else if (target <= m[index][mid]) {
                end = mid;
                mid = (begin + end) / 2;
                return findCol(begin, mid, end, target, index);
            } else {
                return -1;
        
            }
        }
    }
}


/* binary search the m*n  */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int m = row*col;
        int begin = 0;
        int end = m-1;
        int index = 0;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matrix[mid/col][mid%col] == target) {
                return true;
            }
            if (matrix[mid/col][mid%col] < target) {
                begin = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
    
    
}



