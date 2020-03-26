// This is a maxmin problem, use the recursion with memory.

class Solution {
    // dp[] store the state that number<=maxChoosableInteger has not been choosen(0),
    // choosen and make 1st player win (1), choosen and make 1st player lose (-1)
    private byte dp[];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if (desiredTotal <= 0) {
            return true;
        }
        if (sum < desiredTotal) {
            return false;
        }
        dp = new byte[1 << maxChoosableInteger];
        return canIWin(maxChoosableInteger, desiredTotal, 0);
    }
    
    // state is the number choosen combination (for example, if m=3, and 1 and 2 has already been choosen)
    // state = 011
    private boolean canIWin(int m, int t, int state) {
        if (t <= 0) {
            // player 1 move first, if t<=0 means player 2 has already win
            return false;
        }
        if (dp[state] != 0) {
            // check if combination=state has already been valued, return the validated result
            return dp[state]==1;
        }
        for (int i=0; i<m; i++) {
            // if a number has already been choose, continue
            if ((state & (1<<i)) > 0) {
                continue;
            }
            // let player 1 choose a number, then player 2 call this function
            // if player 2 cannot win, remember this choice combination can make player 1 win
            if (!canIWin(m, t-(i+1), (state | (1<<i)))) {
                dp[state] = 1;
                return true;
            }
        }
        // if all choices cannot make player 1 win, remember this choice combination cannot make player 1 win
        dp[state] = -1;
        return false;
    }
}