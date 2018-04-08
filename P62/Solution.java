class Solution {
    public int uniquePaths(int m, int n) {
      int[][] ans= new int[m+1][n+1];
      ans[0][0] = 1;
      ans[0][1] = 1;
      ans[1][0] = 1;
      return helper(m, n , ans);
    }
    private int helper(int m , int n , int[][] ans){
      if(ans[m-1][n-1] != 0 ) return ans[m-1][n-1];
      if(m == 1){
        ans[0][n - 1 ] = helper(1, n-1, ans);
        return ans[0][n-1];
      }
      if(n == 1){
        ans[m-1][0] = helper(m-1, 1, ans);
        return ans[m - 1][0];
      }
      ans[m - 1][n - 1] = helper(m-1, n, ans) + helper(m, n-1, ans);
      return ans[m-1][n-1];
    }
}
