import java.util.*;
class Solution {
    public int longestPalindromeSubseq(String s) {
      if (s == null || s.length() == 0) return 0;
      int l = s.length();
      int max = 1;
      int[][] dp = new int[l][l];
      for (int i = 0; i < l; i++) dp[i][i] = 1;
      for (int i = 1; i < l; i++)
        for (int j = i - 1; j >= 0; j--)
          if (s.charAt(j) == s.charAt(i))
            dp[j][i] = dp[j + 1][i - 1] + 2;
          else
            dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
      return dp[0][l - 1];
    }
}
