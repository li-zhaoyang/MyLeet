import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
      boolean[][] hasInTen = new boolean[27][9];
      int val = 0;
      for(int i = 0 ; i < 27; i++){
        for(int j = 0 ; j < 9; j++){
          hasInTen[i][j] = false;
        }
      }

      for(int i = 0 ; i < board.length; i++){
        for(int j = 0 ; j < board[i].length ; j++){
          if(board[i][j] != '.'){
            val = board[i][j] - '0';
            if( !setTrue(hasInTen, i ,j, val) ) return false;
            //System.out.println(boardI[i][j]);
          }
        }
      }
      return true;

    }

    public boolean setTrue(boolean[][] hasInTen, int iIndex,int jIndex, int val){
      if( hasInTen[iIndex][val-1] || hasInTen[jIndex + 9][val-1] || hasInTen[3 * (iIndex/3) +  (jIndex/3) + 18][val-1] ) return false;
      hasInTen[iIndex][val-1] = true;
      hasInTen[jIndex + 9][val-1] = true;
      hasInTen[3 * (iIndex/3) +  (jIndex/3) + 18][val-1] = true;
      return true;
    }

}
