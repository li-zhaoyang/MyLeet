class Solution {
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] travelled = new boolean[m][n];
      int count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (travelled[i][j])  continue;
          if (grid[i][j] == '0')  continue;
          count++;
          find(grid, travelled, i, j, m, n);
        }
      }
      return count;
    }

    private void find(char[][] grid, boolean[][] travelled, int i, int j, int m, int n) {
      if (grid[i][j] == '0' || travelled[i][j])  return;
      travelled[i][j] = true;
      if (i != 0) find(grid, travelled, i - 1, j, m, n);
      if (i != m - 1) find(grid, travelled, i + 1, j, m, n);
      if (j != 0) find(grid, travelled, i, j - 1, m, n);
      if (j != n - 1) find(grid, travelled, i, j + 1, m, n);
    }
}
