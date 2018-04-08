public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if( A == null || A.length() == 0 || B == null || B.length() == 0) return 0;
        int l1 = A.length();
        int l2 = B.length();
        int[][] dp = new int[l1][l2];
        int max = 0;
        for (int i = 0; i < l1; i++) {
          for (int j = 0; j < l2; j++) {
            if (A.charAt(i) == B.charAt(j)) {
              if (i == 0 || j == 0) dp[i][j] = 1;
              else dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
              if (i > 0 && j > 0)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
          }
        }
        return dp[l1 - 1][l2 - 1];
    }
}
