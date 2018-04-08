class Solution {
    public int minPathSum(int[][] grid) {
      int m = grid.length;
      if(m == 0)  return 0;
      int n = grid[0].length;
      int[][] ans= new int[m][n];
      int sum = 0;
      for(int i = 0 ; i < m; i++){
        if(i == 0)  ans[i][0] = grid[0][0];
        else  ans[i][0] = grid[i][0] + ans[i-1][0];
      }
      for(int i = 0 ; i < n; i++){
        if(i == 0)  ans[0][i] = grid[0][0];
        else  ans[0][i] = grid[0][i] + ans[0][i-1];
      }
      // int minMN = m<n?m:n;
      for(int j = 1; j < n ; j ++){
        for(int i = 1; i < m ; i ++){
          ans[i][j] = (ans[i-1][j] < ans[i][j-1]?ans[i-1][j]:ans[i][j-1]) + grid[i][j];
        }
      }
      return ans[m-1][n-1];
    }
}
