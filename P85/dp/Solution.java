import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
      int m = matrix.length, n = matrix[0].length, max = 0;
      int[] height = new int[n];
      int[] left = new int[n];
      int[] right = new int[n];
      Arrays.fill(right, n);

      for(int i = 0 ; i < m ; i ++){
        int curLeft = 0, curRight = n;
        for(int j = 0; j < n ; j ++){
          if(matrix[i][j] == '1'){
            height[j] ++;
            left[j] = left[j] > curLeft ? left[j] : curLeft ;
          }
          else{
            height[j] = 0;
            left[j] = 0;
            curLeft = j + 1;
          }
          if(matrix[i][n - j - 1] == '1'){
            right[n - j - 1] = right[n - j - 1] < curRight ? right[n - j - 1] : curRight;
          }
          else{
            right[n - j - 1] = n;
            curRight = n - j - 1;
          }
        }
        for(int j = 0; j < n ; j ++){
          int thisArea = (right[j] - left[j]) * height[j];
          max = max > thisArea ? max : thisArea ;
        }
      }
      return max;
    }
}
