class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] delta = new int[prices.length-1];
        int result = 0;
        for(int i = 0;i < delta.length;i++) {
            delta[i] = prices[i+1]-prices[i];
            if(delta[i] > 0) result += delta[i];
        }
        return result;
    }
}
