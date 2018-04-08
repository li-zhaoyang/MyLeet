class Solution {
    public int coinChange(int[] coins, int amount) {
      int n = coins.length;
      int[][] dp = new int[n + 1][amount + 1];
      for (int i = 0 ; i <= n; i ++)
        for (int j = 1; j <= amount; j++)
          dp[i][j] = Integer.MAX_VALUE;
      dp[0][0] = 0;
      int min = Integer.MAX_VALUE;
      for (int i = 1 ; i <= n; i ++)
        for (int j = 0; j <= amount; j++) {
          if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE)
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
          else
            dp[i][j] = dp[i - 1][j];
          if (j == amount) {
            min = Math.min(min, dp[i][j]);
            // System.out.println(i + " " + j +" " + min);
          }
        }
      // System.out.println(dp[n][amount]);
      if (min == Integer.MAX_VALUE) min = -1;
      return min;
    }
}
