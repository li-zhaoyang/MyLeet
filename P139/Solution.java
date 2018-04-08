import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      int[] dp = new int[s.length()];
      return helper(0, s, new HashSet<String>(wordDict), dp);
    }

    private boolean helper(int start, String s, HashSet<String> wordDict, int[] dp) {
      if (start == s.length()) {
        return true;
      }
      if (dp[start] != 0)
        return dp[start] > 0;
      for (int i = start + 1; i <= s.length(); i++) {
        if (wordDict.contains(s.substring(start, i)))
          if (helper(i, s, wordDict, dp)){
            dp[start] = 1;
            return true;
          }
      }
      dp[start] = -1;
      return false;
    }
}
