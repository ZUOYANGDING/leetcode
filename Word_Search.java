class Solution {
    private char[][] temp;
    private String target;
    private boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        temp = board;
        target = word;
        visit = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                res = findSolution(0, word.length(), i, j);
                if (res) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean findSolution(int level, int length, int row, int col) {
        if (length == level) {
            return true;
        }
        if (row<0 || row>=temp.length || col<0 || col>=temp[0].length || 
            temp[row][col]!=target.charAt(level) || visit[row][col]) {
            return false;
        }
        visit[row][col] = true;
        boolean res = findSolution(level+1, length, row-1, col) || 
                        findSolution(level+1, length, row+1, col) ||
                        findSolution(level+1, length, row, col+1) ||
                        findSolution(level+1, length, row, col-1);
        visit[row][col] = false;
        return res; 
    }
}