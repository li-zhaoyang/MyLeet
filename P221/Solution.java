class Solution {
    public int maximalSquare(char[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] up1Num = new int[m][n];
      int[][] left1Num = new int[m][n];
      int[][] curSqrLength = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0) up1Num[i][j] = matrix[i][j] == '1' ? 1 : 0;
          else up1Num[i][j] = matrix[i][j] == '1' ? up1Num[i - 1][j] + 1 : 0;
        }
      }
      for (int j = 0; j < n; j++) {
        for (int i = 0; i < m; i++) {
          if (j == 0) left1Num[i][j] = matrix[i][j] == '1' ? 1 : 0;
          else left1Num[i][j] = matrix[i][j] == '1' ? left1Num[i][j - 1] + 1 : 0;
        }
      }
      int maxLength = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == '0')  continue;
          else {
            if (i == 0 || j == 0) curSqrLength[i][j] = 1;
            else {
              curSqrLength[i][j] = Math.min(Math.min(up1Num[i][j], left1Num[i][j]), curSqrLength[i - 1][j - 1] + 1);
            }
            if (curSqrLength[i][j] > maxLength) maxLength = curSqrLength[i][j];
          }
        }
      }
      return maxLength * maxLength;
    }
}
