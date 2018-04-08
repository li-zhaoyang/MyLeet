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

      int[][] dp = new int[k + 1][l];
      for(int i = 1 ; i < k + 1; i ++){
        int thisMax = dp[i-1][0] - prices[0];
        for(int j = 1 ; j < l; j ++){
          int thisDP = dp[i][j-1];
          if(thisDP < thisMax + prices[j])  thisDP = thisMax + prices[j];
          dp[i][j] = thisDP;
          if(thisMax < dp[i - 1][j] - prices[j])  thisMax =  dp[i - 1][j] - prices[j];
        }
      }

      return dp[k][l-1];

    }
}
