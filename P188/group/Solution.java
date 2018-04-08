import java.util.*;
class Solution {
    public int maxProfit(int k, int[] prices) {
      int l = prices.length;
      if(l < 2 || k == 0) return 0;
      if(k >=  l/2) {
		      int maxPro = 0;
		      for (int i = 1; i < l; i++) {
			         if (prices[i] > prices[i-1])  maxPro += prices[i] - prices[i-1];
		      }
		      return maxPro;
	    }
      int[][] dp = new int[l + 1][k + 1];
      for(int j = 1 ; j <= k; j ++){
        int maxForI0 = Integer.MIN_VALUE;
        for (int i = 1; i <= l; i++) {
          if (i >= 2) {
            maxForI0 = Math.max(maxForI0, dp[i - 2][j - 1] - prices[i - 2]);
          }
          dp[i][j] = Math.max(dp[i - 1][j], prices[i - 1] + maxForI0);
          // for (int i0 = 0; i0 <= i - 2; i0 ++) {    //sold out day of last buy
          //   dp[i][j] = Math.max(dp[i][j], dp[i0][j - 1] + prices[i - 1] - prices[i0 + 1 - 1]);
          // }
        }
      }
      return dp[l][k];

    }
}
