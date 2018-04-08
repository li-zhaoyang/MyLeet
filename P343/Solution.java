import java.util.*;
class Solution {
    public int integerBreak(int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, Integer.MIN_VALUE);
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
        for (int lastNum = 1; lastNum + 1 <= i; lastNum ++) {
          dp[i] = Math.max(dp[i], lastNum * dp[i - lastNum]);
        }
        if (i == n) return dp[i];
        dp[i] = Math.max(dp[i], i);
        // System.out.println(dp[i]);
      }

      return dp[n];
    }
}
