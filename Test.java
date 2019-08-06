import java.util.*;

public class Test {
	private char[][] board;
    private List<List<String>> res;
    private int[] row;
    private int[] col;
	public static void main(String[] args) {
		res = new ArrayList<>();
        board = new char[8][8];
        row = new int[8];
        col = new int[8];
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                board[i][j] = '.';
            }
        }
        findSolution(n, 0);
        for (int i=0; i<res.size(); i++) {
        	ArrayList<String> temp = res.get(i);
        	for (int j=0; j<temp.size(); j++) {
        		System.out.println(temp.get(j));
        	}
        }
    }
    public void findSolution(int n, int exist) {
        if (exist == n) {
            List<String> new_res = new ArrayList<String>();
            for (int i=0; i<8; i++) {
                String temp = "";
                for (int j=0; j<8; j++) {
                    temp+=board[i][j];
                }
                new_res.add(temp);
            }
            res.add(new_res);
            return;
        }
        for (int i=0; i<8; i++) {
            if (row[i]==1) {
                continue;
            }
            for (int j=0; j<8; j++) {
                if(col[j]==1) {
                    continue;
                }
                board[i][j] = 'Q';
                row[i] = 1;
                row[j] = 1;
                exist++;
                findSolution(n, exist);
                exist--;
                row[i] = 0;
                row[j] = 0;
                board[i][j] = '.';
            }
        }
        return;
    }
}
