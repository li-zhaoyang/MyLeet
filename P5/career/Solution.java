class Solution {
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) return "";
      int max = 1;
      String ans = s.substring(0, 1);
      int l = s.length();
      boolean[][] dp = new boolean[l][l];
      for (int i = 0; i < l; i++) dp[i][i] = true;
      for (int i = 1; i < l; i++)
        for (int j = 0; j < i; j++)
          if (s.charAt(j) == s.charAt(i) && (i == j + 1 || dp[j + 1][i - 1])) {
            dp[j][i] = true;
            if (i - j + 1 > max) {
              max = i - j + 1;
              ans = s.substring(j, i + 1);
            }
          }
      return ans;
    }
}
