class Solution {
    public int numIslands(char[][] grid) {
      if(grid == null)  return 0;
      if(grid.length == 0)  return 0;
      if(grid[0].length == 0) return 0;
      int num = 0;

      for(int i = 0 ; i < grid.length; i ++ ){
        for(int j = 0 ; j < grid[i].length ; j++){
          if(grid[i][j] == '1'){
            num++;
            changeToZero(grid, i, j);
          }
        }
      }
      return num;
    }

    private void changeToZero(char[][] grid, int i, int j){
      if(i == -1 || i == grid.length)  return;
      if(j == -1 || j == grid[i].length ) return;
      if(grid[i][j] == '0') return;
      grid[i][j] = '0';
      changeToZero(grid, i + 1, j);
      changeToZero(grid, i - 1, j);
      changeToZero(grid, i, j + 1);
      changeToZero(grid, i, j - 1);
    }
}
