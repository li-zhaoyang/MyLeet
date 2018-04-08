import java.util.*;
class Solution {
    public void solveSudoku(char[][] board) {
      List<Integer>[] remainRow = new ArrayList[9];
      List<Integer>[] remainCol = new ArrayList[9];
      List<Integer>[] remainSqa = new ArrayList[9];
      int remainDot = 0;
      List<Integer> allNum = new ArrayList<Integer>();
      for(int i = 1; i < 10 ; i++){
        allNum.add(i);
      }
      for(int i = 0 ; i < 9 ; i ++ ){
        remainRow[i] = new ArrayList<Integer>(allNum);
        remainCol[i] = new ArrayList<Integer>(allNum);
        remainSqa[i] = new ArrayList<Integer>(allNum);
      }

      for(int i = 0 ; i < board.length ; i ++){
        for(int j = 0 ; j < board[i].length ; j++){
          if(board[i][j] != '.'){
            int thisVal = board[i][j] - '0';
            remainRow[i].remove((Integer) thisVal);
            remainCol[j].remove((Integer) thisVal);
            remainSqa[3 * (i/3) +  (j/3)].remove((Integer) thisVal);
          }else{
            remainDot ++ ;
          }
        }
      }
      helpSolve(remainDot, board, remainRow, remainCol, remainSqa );
    }


    private boolean helpSolve(int remainDot, char[][] board, List<Integer>[] remainRow, List<Integer>[] remainCol, List<Integer>[] remainSqa){
      if(remainDot == 0)  return true;
      for(int i = 0 ; i < 9; i ++){
        for(int j = 0 ; j < 9 ; j ++){
          if(board[i][j] == '.'){
            List<Integer> possible = new ArrayList<Integer>(remainRow[i]);
            possible.retainAll(remainCol[j]);
            possible.retainAll(remainSqa[3 * (i/3) +  (j/3)]);
            if(possible.size() == 0)  return false;
            for(int k = 0; k < possible.size() ; k++){
              int thisVal = possible.get(k) ;
              board[i][j] = (char)(thisVal + '0');
              remainRow[i].remove((Integer) thisVal);
              remainCol[j].remove((Integer) thisVal);
              remainSqa[3 * (i/3) +  (j/3)].remove((Integer) thisVal);
              if( helpSolve(remainDot - 1, board, remainRow, remainCol, remainSqa) )  return true;
              remainRow[i].add( thisVal);
              remainCol[j].add( thisVal);
              remainSqa[3 * (i/3) +  (j/3)].add(thisVal);
              board[i][j] = '.';
            }
            return false;
          }
        }
      }
      return false;
    }
}
