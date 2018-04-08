class Solution {
  //The first way returns unique combinations. Not with sequence.
  // public int combinationSum4(int[] nums, int target) {
  //   if (nums == null || nums.length == 0) return 0;
  //   int l = nums.length;
  //   int[][] dp = new int[l + 1][target + 1];
  //   dp[0][0] = 1;
  //   for (int i = 1; i <= l; i++) {
  //     dp[i][0] = 1;
  //     for (int j = 1; j <= target; j++) {
  //       if (j < nums[i - 1]) {
  //         dp[i][j] = dp[i - 1][j];
  //       } else {
  //         dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
  //       }
  //     }
  //   }
  //   for (int i = 0; i <= l; i++) {
  //     for (int j = 0; j <= target; j++) {
  //       System.out.print(dp[i][j] + "\t");
  //     }
  //     System.out.println();
  //   }
  //   return dp[l][target];
  // }
  public int combinationSum4(int[] nums, int target) {
    if (nums == null || nums.length == 0 ) return 0;
    int l = nums.length;
    int[] dp = new int[target + 1];
    //dp[i] ans of sum i
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= target)  dp[nums[i]] = 1;
    }
    for (int i = 0; i <= target; i++) {
      for (int index = 0; index < l; index++) {
        if (i - nums[index] >= 0) dp[i] += dp[i - nums[index]];
      }
    }
    return dp[target];
  }
}
