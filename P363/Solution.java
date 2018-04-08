import java.util.*;
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
      int m = matrix.length;
      int n = matrix[0].length;
      int k0 = k;
      int[][][][] dp = new int[m][n][m][n];
      int max = Integer.MIN_VALUE;
      for (int w = 1; w <= m; w++) {
        for (int h = 1; h <= n; h++) {
          for (int i = 0; i <= m - w; i++) {
            for (int j = 0; j <= n - h; j++) {
              k = i + w - 1;
              int l = j + h - 1;
              dp[i][j][k][l] = matrix[k][l];
              if (k - 1 >= i && l - 1 >= j) {
                dp[i][j][k][l] += dp[i][j][k - 1][l - 1];
                dp[i][j][k][l] += dp[i][l][k - 1][l];
                dp[i][j][k][l] += dp[k][j][k][l - 1];
              }
              else if (k - 1 >= i) dp[i][j][k][l] += dp[i][l][k - 1][l];
              else if (l - 1 >= j) dp[i][j][k][l] += dp[k][j][k][l - 1];
              if (dp[i][j][k][l] <= k0 && dp[i][j][k][l] > max) max = dp[i][j][k][l];
              // System.out.println(i +" " + j +" " + k +" " + l +" " + dp[i][j][k][l]);
            }
          }
        }
      }
    return max;
    }
}
