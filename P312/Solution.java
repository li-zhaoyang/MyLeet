import java.util.*;
class Solution {
    public int maxCoins(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int l = nums.length;
      int[] newNums = new int[l + 2];
      newNums[0] = newNums[l + 1] = 1;
      for (int i = 1; i < l + 1; i++) {
        newNums[i] = nums[i - 1];
      }
      int[][] dp = new int[l + 2][l + 2];
      return helperBurst(1, l, dp, newNums);
    }

    private int helperBurst(int start, int end, int[][] dp, int[] nums) {
      if (dp[start][end] != 0)  return dp[start][end];
      if (start > end)  return 0;
      for (int i = start; i <= end; i++) {
        dp[start][end] = Math.max(dp[start][end], helperBurst(start, i - 1, dp, nums) + nums[start - 1] * nums[i] * nums[end + 1] + helperBurst(i + 1, end, dp, nums));
      }
      return dp[start][end];
    }
}
