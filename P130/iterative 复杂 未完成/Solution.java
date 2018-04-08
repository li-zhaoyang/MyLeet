import java.util.*;
class Solution {
    public void solve(char[][] board) {
      int m = board.length;
      if(m == 0)  return;
      int n = board[0].length;
      if(m < 3 || n < 3)  return;
      Set<Integer> travelled = new HashSet<Integer>();
      for(int i = 0 ; i < m ; i ++){
        for(int j = 0 ; j < n ; j ++){
          if(board[i][j] == 'O' && (!travelled.contains(i*n + j))){
            Set<Integer> thisTravel = new HashSet<Integer>();
            if(travelAll(board, thisTravel, m, n, i, j)){
              for(int pos:thisTravel){
                board[pos/n][pos%n] = 'X';
              }
            }
            travelled.addAll(thisTravel);
          }
        }
      }

    }
    private boolean travelAll(char[][] board, Set<Integer> thisTravel, int m, int n, int iStart , int jStart){
      boolean ans = true;
      if( iStart == 0 || jStart == 0) ans = false;
      int lastJStart = jStart, lastJend = n - 1, thisJStart = jStart;
      boolean firstLine = true;
      for(int i = iStart; i < m; i++){
        boolean first = true;
        int j = 0;
        if(firstLine){ j = jStart; firstLine = false;}
        for( ; j < n; j++){
          if(board[i][j] == 'X' ){
            if(first) continue;
            if(j <= lastJStart) {
              first = true;
              continue;
            }
            break;
          }
          if(first){
            if(j > lastJend) break;
            thisJStart = j;
            first = false;
          }
          if(j == n - 1)  ans = false;
        }
        if(first) return ans;
        lastJStart = thisJStart;
        if(lastJStart == 0) ans = false;
        lastJend = j - 1;
        for(int k = thisJStart ; k <= lastJend; k ++){
          thisTravel.add(i*n + k);
        }
      }
      return false;
    }
}
