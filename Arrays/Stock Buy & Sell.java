class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit = 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){ 
            minCost = Math.min(minCost, prices[i]); 
            maxprofit = Math.max(maxprofit, prices[i]-minCost);
        }
        return maxprofit;
    }
}
