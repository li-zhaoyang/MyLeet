class Solution {
    public boolean canCross(int[] stones) {
      if (stones == null || stones.length == 0) return true;
      int l = stones.length;
      boolean[][] dp = new boolean[l][1200];
      HashMap<Integer, Integer> posToIndexMap = new HashMap<Integer, Integer>();
      for (int i = 0; i < l; i++) {
        posToIndexMap.put(stones[i], i);
      }
      dp[0][0] = true;
      for (int i = 0; i < l; i++) {
        for (int k = 0; k < 1200; k++) {
          if (dp[i][k]) {
            if (i == l - 1) return true;
            if (k - 1 > 0 && posToIndexMap.containsKey(stones[i] + k - 1)) dp[posToIndexMap.get(stones[i] + k - 1)][k - 1] = true;
            if (k > 0 && posToIndexMap.containsKey(stones[i] + k)) dp[posToIndexMap.get(stones[i] + k)][k] = true;
            if (k + 1 > 0 && posToIndexMap.containsKey(stones[i] + k + 1)) dp[posToIndexMap.get(stones[i] + k + 1)][k + 1] = true;
          }
        }
      }
      return false;
    }
}
