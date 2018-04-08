class Solution {
    public void gameOfLife(int[][] board) {
      if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return ;
      int m = board.length;
      int n = board[0].length;
      int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
      int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int liveNeighbor = 0;
          for (int k = 0; k < 8; k++) {
            if(getLive(board, i + di[k], j + dj[k], m, n)) liveNeighbor++;
          }
          if (board[i][j] == 1) {
            if (liveNeighbor == 2 || liveNeighbor == 3) board[i][j] = 3;
          } else {
            if (liveNeighbor == 3)  board[i][j] = 2;
          }
        }
      }
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          board[i][j] = board[i][j] >> 1;
        }
      }
    }


    private boolean getLive(int[][] board, int i, int j, int m, int n) {
      if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] & 1 == 0) return false;
      return true;
    }
}
