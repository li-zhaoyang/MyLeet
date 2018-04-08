class Solution {
    public int countSubstrings(String s) {
      if (s == null) return 0;
      int l = s.length();
      if (l < 2) return l;
      boolean[][] dp = new boolean[l][l];

      for (int i = 0; i < l; i++) {
        dp[i][i] = true;
      }
      for (int i = 1; i < l ; i ++) {
        for (int j = 0; j < i; j++) {
          if (s.charAt(i) == s.charAt(j) && (dp[j + 1][i - 1] || j + 1 == i))  dp[j][i] = true;
        }
      }
      int count = 0;
      for (int i = 0; i < l; i++) {
        for (int j = 0; j <= i; j++) {
          if (dp[j][i]) count++;
        }
      }
      return count;
    }
}
