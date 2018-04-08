class Solution {
    public int numberOfArithmeticSlices(int[] A) {
      if (A == null || A.length == 0) return 0;
      int l = A.length;
      int[] dp = new int[l];
      Arrays.fill(dp, 1);
      for (int i = 2; i < l; i++) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
          dp[i] = dp[i - 1] + 1;
        }
      }
      int num = 0;
      for (int i = 2; i < l; i++) {
        if (dp[i] >= 2) num += dp[i] - 1;
      }
      return num;
    }
}
