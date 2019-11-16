// Go through the prices array, use 2 variable one is to record the min price before the current day, 
// and the other one is the record the max profit before the current day; update these 2 variable.
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        if (prices.length==0 || prices.length==1) {
            return max_profit;
        }
        int min_buy = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > min_buy) {
                max_profit = Math.max(max_profit, (prices[i] - min_buy));
            }
            if (min_buy >= prices[i]) {
                min_buy = prices[i];
            }
        }
        return max_profit;
    }
}