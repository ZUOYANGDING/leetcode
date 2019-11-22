/*idea:
This problem has 3 conditions for each day: buy, sell and cooldown, and each condition is transformed from
pre condition in prev day.
                                        ------Rest---
                                        |            |                    
                                  Rest(do nothing)------
                                 |             /|\
                             buy |              | 
                                 |              | rest 
                                \|/             |   
            -------hold(have stock but rest)---- >sell(sell stock on prev day)
            |                       |         sell
             ------rest(do nothing)--         

From the state graph above, we have:
        rest[i] = max(rest[i-1], sell[i-1]) (rest yestoday and today, or rest today but sell yestoday)
        hold[i] = max(rest[i-1]-price[i], hold[i-1]) (rest today or buy stock today)
        sell[i] = hold[i-1] + price[i] (sell stock today)
*/
        
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) {
            return 0;
        }
        int l = prices.length;
        int[] rest = new int[l+1];
        int[] hold = new int[l+1];
        int[] sell = new int[l+1];
        rest[0] = 0;
        hold[0] = Integer.MIN_VALUE;
        sell[0] = 0;
        for (int i=0; i<l; i++) {
            rest[i+1] = Math.max(rest[i], sell[i]);
            hold[i+1] = Math.max(rest[i]-prices[i], hold[i]);
            sell[i+1] = hold[i]+prices[i];
        }
        return Math.max(rest[l], sell[l]);
    }
}