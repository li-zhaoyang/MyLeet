import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      if (envelopes == null || envelopes.length == 0) return 0;
      int n = envelopes.length;
      Arrays.sort(envelopes, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2)() {
          if (o1[0] != o2[0]) return o1[0] - o2[0];
          return o2[1] - o1[1];
        }
      });
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      int max = 1;
      for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
        if (dp[i] > max)  max = dp[i];
      }
      return max;
    }
}
