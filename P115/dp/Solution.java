import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {
      if(s == null || s.length() == 0)  return 0;
      if(t == null || t.length() == 0)  return 0;
      int l1 = s.length();
      int l2 = t.length();
      int[][] dp = new int[l1 + 1][l2 + 1];
      for (int i = 0; i <= l1; i++) {
        dp[i][0] = 1;
      }
      //dp[i][j] = number in first i character in s, first j character in t
      for (int i = 1; i <= l1; i++) {
        for (int j = 1; j <= l2; j++) {
          if (s.charAt(i - 1) == t.charAt(j - 1))
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
          else dp[i][j] = dp[i - 1][j];
        }
      }
      return dp[l1][l2] ;
    }

}
