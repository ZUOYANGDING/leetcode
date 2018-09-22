class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> temp = new HashSet<>();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j]=='.'){
                    continue;
                }
                if (!temp.contains(board[i][j])){
                    temp.add(board[i][j]);
                } else {
                    return false;
                }
            }
            temp.clear();
        }
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[j][i]=='.'){
                    continue;
                }
                if (!temp.contains(board[j][i])){
                    temp.add(board[j][i]);
                } else {
                    return false;
                }
            }
            temp.clear();
        }
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (!checkRepeat(board, temp, i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkRepeat(char[][] board, HashSet<Character> temp, int line, int col){
        for (int i=line*3; i<line*3+3; i++){
            for (int j=col*3; j<col*3+3; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                if (!temp.contains(board[i][j])){
                    temp.add(board[i][j]);
                } else{
                    return false;
                }
            }
        }
        temp.clear();
        return true;
    }
    
}