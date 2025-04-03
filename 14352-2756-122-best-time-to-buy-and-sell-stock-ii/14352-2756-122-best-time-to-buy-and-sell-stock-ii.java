class Solution {
    public int maxProfit(int[] prices) {
        int currPrice = -1;
        int profit = 0;

        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1] && currPrice == -1){
                currPrice = prices[i];
            }else if(prices[i] > prices[i + 1] && currPrice != -1) {
                profit += prices[i] - currPrice;
                currPrice = -1;
            }
        }

        if(currPrice != -1){
            profit += prices[prices.length - 1] - currPrice;
        }

        return profit;
    }
}