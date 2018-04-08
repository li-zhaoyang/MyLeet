import java.util.*;
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      if(obstacleGrid[0][0] == 1) return 0;  
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[][] ans= new int[m+1][n+1];
      for(int i = 0 ; i < m+1; i++) Arrays.fill(ans[i], -1);

      ans[0][0] = 1;
      ans[0][1] = 1;
      ans[1][0] = 1;
      return helper(m, n , ans, obstacleGrid);
    }
    private int helper(int m , int n , int[][] ans, int[][] obstacleGrid){
      if(obstacleGrid[m-1][n-1] == 1) {
        ans[m-1][n-1] = 0;
        return 0;
      }
      if(ans[m-1][n-1] != -1 ) return ans[m-1][n-1];

      if(m == 1){
        ans[0][n - 1 ] = helper(1, n-1, ans, obstacleGrid);
        return ans[0][n-1];
      }
      if(n == 1){
        ans[m-1][0] = helper(m-1, 1, ans, obstacleGrid);
        return ans[m - 1][0];
      }
      ans[m - 1][n - 1] = helper(m-1, n, ans, obstacleGrid) + helper(m, n-1, ans, obstacleGrid);
      return ans[m-1][n-1];
    }
}
