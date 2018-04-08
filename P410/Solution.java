class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m == 0) return 0;
        int l = nums.length;
        int[][] sumBetween = new int[l][l];
        int[][] dp = new int[l + 1][m + 1];
        for (int i = 0; i < l; i++) {
          for (int j = i; j < l; j++) {
            if (i == j) sumBetween[i][j] = nums[i];
            else sumBetween[i][j] = sumBetween[i][j - 1] + nums[j];
          }
        }

        for (int i = 1; i <= l; i++) {
          dp[i][1] = nums[i - 1] + dp[i - 1][1];
          for (int j = 2; j <= m; j++) {
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = 1; k < i; k++) {
              int thisMaxFromK = Math.max(dp[k][j - 1], sumBetween[k + 1 - 1][i - 1]);
              dp[i][j] = Math.min(thisMaxFromK, dp[i][j]);
            }
          }
        }
        for (int i = 0; i <= l; i++) {
          for (int j = 0; j <= m; j++) {
            System.out.print(dp[i][j] + "\t");
          }
          System.out.println();
        }
        return dp[l][m];
    }
}
