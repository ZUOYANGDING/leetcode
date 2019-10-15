/* The valid solution must be:
    1) Each pattern must connect at least m keys and at most n keys.
    1) All the keys must be distinct.
    3) If the line connecting two consecutive keys in the pattern passes through any other keys, 
    the other keys must have previously selected in the pattern. 
    No jumps through non selected key is allowed. The order of keys used matters.
   Therefore, apply a 9*9 matrix to record if there is a key between 2 keys; also apply an array to record
   if a key is visited or not. From the start place, if the next key has not been visited, and there is no
   key need to be passed between the present key and next key or the key between the present and next key has
   already been visited, go to the next key (recursive to next level). If next key has been visited, and passed
   a visited key or no need to pass a key, the route still valid (like return back), but do not count as a new result,
   and the length of the result do not increase. If the key has not been visited or need to pass a visited key, the route
   invalid, need to try an other possible key. 
*/

class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] matrix = new int[10][10];
        int[] visit = new int[10];
        matrix[1][3] = matrix[3][1] = 2;
        matrix[1][7] = matrix[7][1] = 4;
        matrix[2][8] = matrix[8][2] = matrix[4][6] = matrix[6][4] = matrix[1][9] = matrix[9][1]
            = matrix[3][7] = matrix[7][3] = 5;
        matrix[3][9] = matrix[9][3] = 6;
        matrix[7][9] = matrix[9][7] = 8;
        int res = 0;
        int length = 1;
        res += findSolution(1, 0, m, n, length, matrix, visit) * 4;
        res += findSolution(2, 0, m, n, length, matrix, visit) * 4;
        res += findSolution(5, 0, m, n, length, matrix, visit);
        return res;
    }
    
    public int findSolution(int place, int res, int m, int n, int length, int[][] matrix, 
                           int[] visit) {
        if (length >= m) {
            res++;
        }
        length++;
        if (length > n) {
            return res;
        }
        visit[place] = 1;
        for (int next=1; next<=9; next++) {
            int check = matrix[place][next];
            if (visit[next]==0 && (check==0 || visit[check]!=0)) {
                res = findSolution(next, res, m, n, length, matrix, visit);
            }
        }
        visit[place] = 0;
        return res;
    }
}