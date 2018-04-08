import java.util.*;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int k = K;
        if (k == n - 1) k = n - 2;
        HashMap<Integer, HashMap<Integer, Integer>> inNeighborTable = new HashMap<Integer, HashMap<Integer, Integer>>();
        for (int[] flight: flights) {
          HashMap<Integer, Integer> thisNeighbors = inNeighborTable.getOrDefault(flight[1], new HashMap<Integer, Integer>());
          thisNeighbors.put(flight[0], flight[2]);
          inNeighborTable.put(flight[1], thisNeighbors);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++)
             if (i == src) dp[i][j] = 0;
             else dp[i][j] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= k + 1; j++) {
          for (int i = 0; i < n; i++) {
            dp[i][j] = dp[i][j - 1];
            if (!inNeighborTable.containsKey(i)) continue;
            HashMap<Integer, Integer> thisNeighbors = inNeighborTable.get(i);
            for (int last: thisNeighbors.keySet()) {
              if (dp[last][j - 1] == Integer.MAX_VALUE) continue;
              dp[i][j] = Math.min(dp[i][j], dp[last][j - 1] + thisNeighbors.get(last));
            }
          }
        }
        return dp[dst][k + 1] == Integer.MAX_VALUE? -1:dp[dst][k + 1];
    }
}
