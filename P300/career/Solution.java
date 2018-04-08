import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int l = nums.length;
      int dp[] = new int[l];
      Arrays.fill(dp, 1);
      int max = 1;
      for (int curPos = 0; curPos < l; curPos++)
        for (int i = 0; i < curPos; i++)
          if (nums[curPos] > nums[i]) {
            dp[curPos] = Math.max(dp[curPos], dp[i] + 1);
            if (dp[curPos] > max) max = dp[curPos];
          }
      return max;
    }
}
