class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 2) return 0;
      int l = prices.length;
      int[] dp = new int[prices.length];
      dp[0] = 0;
      dp[1] = prices[1] - prices[0] > 0? prices[1] - prices[0]:0;
      int thisMaxToPlus = Math.max(- prices[0], - prices[1]);
      for (int i = 2; i < l; i++) {
        dp[i] = Math.max(dp[i - 1], prices[i] + thisMaxToPlus);
        thisMaxToPlus = Math.max(thisMaxToPlus, dp[i - 2] - prices[i]);
      }
      return dp[l - 1];
      // thisMaxToPlus = dp[jj] + price[i] - price[jj + 2], for jj in [-2, i - 3]
      // maxhere = max(dp[i - 1], max (dp[jj] + price[i] - price[jj + 2], for jj in [-2, i - 3]), price[i] - price[0], price[i] - price[1])
    }
}
