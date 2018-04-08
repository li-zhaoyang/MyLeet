import java.util.*;
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] longestFromHere = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          longestFromHere[i][j] = -1;
        }
      }
      int longest = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          longest = Math.max(longest, longestFromIJ(matrix, longestFromHere, i, j, m, n));
        }
      }
      return longest;
    }

    private int longestFromIJ(int[][] matrix, int[][] longestFromHere, int i, int j, int m, int n) {
      if (longestFromHere[i][j] != -1)  return longestFromHere[i][j];
      int thisLongest = 0;
      if (i != 0 && matrix[i - 1][j] > matrix[i][j]) {
        int maxUp = longestFromIJ(matrix, longestFromHere, i - 1, j, m, n);
        if (maxUp > thisLongest) {
          thisLongest = maxUp;
        }
      }
      if (i != m - 1 && matrix[i + 1][j] > matrix[i][j]) {
        int maxDown = longestFromIJ(matrix, longestFromHere, i + 1, j, m, n);
        if (maxDown > thisLongest) {
          thisLongest = maxDown;
        }
      }
      if (j != 0 && matrix[i][j - 1] > matrix[i][j]) {
        int maxLeft = longestFromIJ(matrix, longestFromHere, i, j - 1, m, n);
        if (maxLeft > thisLongest) {
          thisLongest = maxLeft;
        }
      }
      if (j != n - 1 && matrix[i][j + 1] > matrix[i][j]) {
        int maxRight = longestFromIJ(matrix, longestFromHere, i, j + 1, m, n);
        if (maxRight > thisLongest) {
          thisLongest = maxRight;
        }
      }
      longestFromHere[i][j] = thisLongest + 1;
      return thisLongest + 1;
    }


}
