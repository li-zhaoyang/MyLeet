class Solution {
    public int maximalRectangle(char[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
      int m = matrix.length;
      int n = matrix[0].length;
      boolean[][][][] dp = new boolean[m][n][m][n];
     int max = 0;
     for (int w = 1; w <= m; w++) {
       for (int h = 1; h <= n; h++) {
         for (int i = 0; i <= m - w; i++) {
           for (int j = 0; j <= n - h; j++) {
             int k = i + w - 1;
             int l = j + h - 1;
             if (matrix[k][l] == '0') continue;
             if (k - 1 >= i && l - 1 >= j) {
               dp[i][j][k][l] = dp[i][j][k - 1][l - 1] && dp[i][l][k - 1][l] && dp[k][j][k][l - 1]; //A
             }
             else if (k - 1 >= i) dp[i][j][k][l] = dp[i][l][k - 1][l];   //B
             else if (l - 1 >= j) dp[i][j][k][l] = dp[k][j][k][l - 1];
             else dp[i][j][k][l] = true;
             if (dp[i][j][k][l] && w * h > max) max = w * h;
             // System.out.println(i +" " + j +" " + k +" " + l +" " + dp[i][j][k][l]);
           }
         }
       }
     }
   return max;
    }
}
