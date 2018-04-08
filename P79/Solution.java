class Solution {
    public boolean exist(char[][] board, String word) {
      if(word.length() == 0)  return true;
      int m = board.length;
      if(m == 0)  return false;
      int n = board[0].length;
      if(n == 0)  return false;
      if(word.length() > m*n) return false;
      boolean used[][] = new boolean[m][n];
      for(int i = 0 ; i < m ; i++){
        for(int j = 0; j < n ; j++){
          if(board[i][j] == word.charAt(0)){
            if(findWay(board, used, i , j, m, n, word, 0))  return true;
          }
        }
      }
      return false;
    }

    private boolean findWay(char[][] board, boolean[][] used, int i, int j, int m, int n, String word, int indexOfWord){
      if(used[i][j])  return false;
      if(indexOfWord == word.length() - 1){
        if(board[i][j] == word.charAt(indexOfWord)) return true;
        return false;
      }
      if(board[i][j] == word.charAt(indexOfWord)){
        used[i][j] = true;
        if(i != 0){
          if(findWay(board, used, i-1, j, m, n, word, indexOfWord + 1))  return true;
        }
        if(j != 0){
          if(findWay(board, used, i, j-1, m, n, word, indexOfWord + 1))  return true;
        }
        if(i != m - 1){
          if(findWay(board, used, i+1, j, m, n, word, indexOfWord + 1))  return true;
        }
        if(j != n - 1){
          if(findWay(board, used, i, j+1, m, n, word, indexOfWord + 1))  return true;
        }
        used[i][j] = false;
      }
      return false;
    }
}
