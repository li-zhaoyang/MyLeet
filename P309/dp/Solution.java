class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 2) return 0;
      int l = prices.length;
      int[] dp = new int[l];
      dp[0] = 0;
      int min = prices[0];
      for (int i = 1; i < l; i++) {
        dp[i] = dp[i - 1];
        for (int j = 0; j <= i - 3; j++) {
          dp[i] = Math.max(dp[i], dp[j] + prices[i] - prices[j + 2]);
        }
        dp[i] = Math.min(dp[i], prices[i] - min);
        min = Math.min(min, prices[i]);
      }
      return dp[l - 1];
    }
}
