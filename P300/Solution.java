import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
      if (nums == null) return 0;
      int[] dp = new int[nums.length];
      Arrays.fill(dp, -1);
      return helper(nums, 0, Long.MIN_VALUE, dp);
    }

    private int helper(int[] nums, int index, long currentMax, int[] dp) {
      if (index == nums.length) return 0;
      int maxLength = 0;
      for (int i = index; i < nums.length; i++) {
        if ((long) nums[i] > currentMax) {
          if (dp[i] == -1) dp[i] = helper(nums, i + 1, (long) nums[i], dp);
          maxLength = Math.max(maxLength, 1 + dp[i]);
        }
      }
      return maxLength;
    }
}
