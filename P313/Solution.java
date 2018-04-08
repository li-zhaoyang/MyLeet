import java.util.*;
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
      int[] dp = new int[n];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 1;
      int l = primes.length;
      int[] indexes = new int[l];
      for (int i = 0; i < n; i++) {
        for (int k = 0; k < l; k++) {
          dp[i] = Math.min(dp[i], dp[indexes[k]] * primes[k]);
        }
        for (int k = 0; k < l; k++) {
          if (dp[i] == dp[indexes[k]] * primes[k]) indexes[k]++;
        }
      }
      return dp[n - 1];
    }
}
