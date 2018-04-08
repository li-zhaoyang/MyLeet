//import java.util.*;
class Solution {
    public int[][] generateMatrix(int n) {
      int thisNum = 1;

      int[][] matrix = new int[n][n];

      int start = 0;
      while(true){
        if( start == n/2) break;
        thisNum = fillCircle(matrix, start, n, thisNum );
        start++;
      }
      if(n%2 == 1)  matrix[n/2][n/2] = n*n;
      return matrix;
    }

    public int fillCircle(int[][] matrix, int start, int n, int thisNum){
      int col = 0, row = 0;
      for(col = start; col < n - start -1; col++ )  { matrix[start][col] = thisNum; thisNum++; }
      for(row = start; row < n - start -1; row++ )  { matrix[row][n - start -1] = thisNum; thisNum++; }
      for(col = n - start - 1; col > start; col-- ) { matrix[n - start -1][col] = thisNum; thisNum++; }
      for(row = n - start - 1; row > start; row-- ) { matrix[row][start] = thisNum; thisNum++; }
      return thisNum;
    }
}
