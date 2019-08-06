class Solution {
    private char[][] board;
    private List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        findSolution(0, n);
        return res;
    }
    public void findSolution(int row, int n) {
        if (row == n) {
            List<String> new_res = new ArrayList<>();
            for (int i=0; i<n; i++) {
                String r = "";
                for (int j=0; j<n; j++) {
                    r += board[i][j];
                }
                new_res.add(r);
            }
            res.add(new_res);
            return;
        }
        for (int j = 0; j<n; j++) {
            if (checkValid(row, j, n)) {
                board[row][j] = 'Q';
                findSolution(row+1, n);
                board[row][j] = '.';
            }
        }
    }
    public boolean checkValid(int row, int col, int n) {
        for (int i=0; i<row; i++) {
            if (board[i][col] != '.') {
                return false;
            }
        }
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] != '.') {
                return false;
            }
        }
        for (int i=row-1, j=col+1; i>=0 && j<n; i--, j++) {
            if (board[i][j] != '.') {
                return false;
            }
        }
        return true;
    }
    
}