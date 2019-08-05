class Solution {
    private char[][] temp_board;
    public void solveSudoku(char[][] board) {
        if (board==null || board.length<9 ) {
            return;
        } else {
            temp_board = board;
            findSolution(0);
        }
    }
    
    public boolean findSolution(int num) {
        if (num==81) {
            return true;
        } else {
            int row = num / 9;
            int col = num % 9;
            if (temp_board[row][col] != '.') {
                return findSolution(num+1);
            } else {
                for (char i='1'; i<='9'; i++) {
                    if (checkRow(i, row) && checkCol(i, col) && checkBox(i, row, col)) {
                        temp_board[row][col] = i;
                        if (findSolution(num+1)) {
                            return true;
                        }
                    } 
                }
                temp_board[row][col] = '.';
                return false;
            }
        }
    }
    
    public boolean checkRow(char num, int row) {
        for (int j=0; j<temp_board[0].length; j++) {
            if (temp_board[row][j] == num) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkCol(char num, int col) {
        for (int i=0; i<temp_board.length; i++) {
            if (temp_board[i][col] == num) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkBox(char num, int r, int c) {
        int row = r / 3;
        int col = c / 3;
        for (int i=row*3; i<row*3+3; i++) {
            for (int j=col*3; j<col*3+3; j++) {
                if (temp_board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}