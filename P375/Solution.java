class Solution {
    public int getMoneyAmount(int n) {
      int[][] dp = new int [n + 1][n + 1];
      for (int i = 1; i <= n; i++)  dp[i][i] = 0;
      for (int length = 2; length <= n; length++) {
        for (int i = 1; i + length - 1 <= n; i++) {
          int j = i + length - 1;
          dp[i][j] = Integer.MAX_VALUE;
          for (int k = i; k <= j; k++) {
            int dp1 = 0, dp2 = 0;
            if (k > 0) dp1 = dp[i][k - 1];
            if (k < n) dp2 = dp[k + 1][j];
            dp[i][j] = Math.min(dp[i][j], k + Math.max(dp1, dp2));
          }
        }
      }
      return dp[1][n];
    }
}
