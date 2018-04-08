import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      LinkedList<Integer> ans = new LinkedList<Integer>();
      if (nums == null || nums.length == 0) return ans;
      int l = nums.length;
      Arrays.sort(nums);
      int[] dp = new int[l];
      int[] back = new int[l];
      Arrays.fill(back, -1);
      int max = 0;
      int maxIndex = -1;
      for (int i = 0; i < l; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
          if (nums[i] % nums[j] == 0) {
            if (dp[j] + 1 > dp[i]) {
              dp[i] = dp[j] + 1;
              back[i] = j;
            }
          }
        }
        if (dp[i] > max)  {
          max = dp[i];
          maxIndex = i;
        }
      }
      while(maxIndex != -1) {
        ans.addFirst(nums[maxIndex]);
        maxIndex = back[maxIndex];
      }
      return ans;
    }
}
