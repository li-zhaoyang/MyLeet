import java.util.*;
class Solution {
    public void solve(char[][] board) {
      int m = board.length;
      if(m == 0)  return;
      int n = board[0].length;
      if(m < 3 || n < 3)  return;
      Set<Integer> travelled = new HashSet<Integer>();
      for(int i = 0 ; i < m; i ++){
        if(board[i][0] == 'O')  travelNext(board,travelled, i ,0, m, n);
        if(board[i][n - 1] == 'O')  travelNext(board,travelled, i ,n - 1, m, n);
      }
      for(int j = 1; j < n - 1; j ++){
        if(board[0][j] == 'O')  travelNext(board,travelled, 0 ,j, m, n);
        if(board[m - 1][j] == 'O')  travelNext(board,travelled, m - 1 ,j, m, n);
      }
      for(int i = 0 ; i < m; i ++){
        for(int j = 0 ; j < n ; j ++){
          if(board[i][j] == 'O' && (!travelled.contains(i*n + j)))  board[i][j] = 'X';
        }
      }


    }

    public void travelNext(char[][] board, Set<Integer> travelled, int i, int j, int m, int n){     //i,j are in the board
      if(board[i][j] == 'X')  return;
      if(travelled.contains(i*n + j)) return;
      travelled.add(i*n + j);
      if(i - 1 >= 0)  travelNext(board, travelled, i - 1, j, m, n);
      if(i + 1 < m)  travelNext(board, travelled, i + 1, j, m, n);
      if(j - 1 >= 0)  travelNext(board, travelled, i, j - 1, m, n);
      if(j + 1 < n)  travelNext(board, travelled, i , j + 1, m, n);
    }


}
