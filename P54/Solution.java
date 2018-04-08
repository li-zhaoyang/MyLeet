import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> ans = new LinkedList<Integer>();
      int m = matrix.length;
      if(m == 0)  return ans;
      int n = matrix[0].length;
      if(n == 0)  return ans;
      int startRow = 0, startCol = 0;
      while(true){
        if(startRow == m/2 || startCol == n/2 ) break;
        ans.addAll(thisCircle(matrix, startRow, startCol, m,n ));
        startRow++;
        startCol++;
      }
      int row = 0, col = 0;
      if(m > n && n%2 == 1){
        for(row = n/2; row < m - n/2; row++)  ans.add(matrix[row][n/2]);
      }
      if(m < n && m%2 == 1){
        for(col = m/2; col < n - m/2; col++)  ans.add(matrix[m/2][col]);
      }
      if(m == n && m%2 == 1)  ans.add(matrix[m/2][n/2]);
      return ans;

    }

    public List<Integer> thisCircle(int[][] matrix, int startRow, int startCol, int m, int n){
      List<Integer> thisCircle = new LinkedList<Integer>();
      int col = 0, row = 0;
      for(col = startCol; col < n - startCol -1; col++ )  thisCircle.add(matrix[startRow][col]);
      for(row = startRow; row < m - startRow -1; row++ )  thisCircle.add(matrix[row][n - startCol -1]);
      for(col = n - startCol - 1; col > startCol; col-- ) thisCircle.add(matrix[m - startRow - 1][col]);
      for(row = m - startRow - 1; row > startRow; row-- ) thisCircle.add(matrix[row][startCol]);
      return thisCircle;
    }
}
