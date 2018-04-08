class Solution {
    public int uniquePaths(int m, int n) {
      if (m <= 0 || n <= 0) return 1;
      int[][] ans= new int[m][n];
      ans[0][0] = 1;
      return helper(m - 1, n - 1, ans);
    }

    private int helper(int m, int n, int[][] ans){
      if (ans[m][n] != 0) return ans[m][n];
      if (m == 0) {
        ans[m][n] = helper(m, n - 1, ans);
        return ans[m][n];
      }
      if (n == 0) {
        ans[m][n] = helper(m - 1, n, ans);
        return ans[m][n];
      }
      ans[m][n] = helper(m - 1, n, ans) + helper(m, n - 1, ans);
      return ans[m][n];
    }

}
