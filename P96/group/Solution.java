class Solution {
    public int numTrees(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      return numTreesHelper(n, dp);
    }

    private int numTreesHelper(int n, int[] dp) {
      if (dp[n] != 0) return dp[n];
      int sum = 0;
      for (int i = 0; i < n; i ++) {
        sum += (numTreesHelper(i, dp) + numTreesHelper(n - i - 1, dp))
      }
      dp[n] = sum;
      return sum;
    }
}
