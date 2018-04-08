class Solution {
    public boolean isMatch(String s, String p) {
      if(s == null) return false;
      if(p == null) return false;
      int l1 = s.length();
      int l2 = p.length();
      boolean[][] dp = new boolean[l1 + 1][l2 + 1];
      dp[0][0] = true;
      for (int i = 0; i < l2 - 1; i += 2) {
        if (p.charAt(i + 1) == '*') dp[0][i + 2] = true;
        else break;
      }
      for (int i = 0; i < l2 - 1; i++) {
        if (p.charAt(i) == '*' && p.charAt(i + 1) == '*') return false;
      }
      for (int j = 1; j <= l2; j++) {
        boolean trueForJMinusTwo = false;
        for (int i = 1; i <= l1; i++) {
          if (j >= 2 && dp[i - 1][j - 2])  trueForJMinusTwo = true;
          if (p.charAt(j - 1) == '.') dp[i][j] = dp[i - 1][j - 1];
          else if (p.charAt(j - 1) == '*') {
            if (j < 2)  return false;
            if (p.charAt(j - 2) != s.charAt(i - 1)) dp[i][j] = dp[i][j - 2];
            if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
              dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
            }
          } else {
            dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1));
          }
          // System.out.println("i:" + i + " j:" + j + ": "+ dp[i][j]);
        }
      }
      for (int i = 0; i <= l1; i++) {
        for (int j = 0; j <= l2 ; j++) {
          System.out.print(dp[i][j] + "\t");
        }
        System.out.println();
      }
      return dp[l1][l2];

    }

}
