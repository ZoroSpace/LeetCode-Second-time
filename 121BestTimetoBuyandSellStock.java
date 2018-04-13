class Solution {
    public int maxProfit(int[] prices) {
        int maxSofar = 0;
        int result = 0;
        for(int i = 1;i < prices.length;i++) {
            maxSofar = Math.max(0,maxSofar + prices[i]-prices[i-1]);
            result = Math.max(result,maxSofar);
        }
        return result;
    }
}
