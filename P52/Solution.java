import java.util.*;
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
      if(n == 0)  return 0;
      boolean[] pos = new boolean[n];
      boolean[] rightUpSum = new boolean[n*2];
      boolean[] rightDownDiff = new boolean[n*2];
      helpSolve(pos, rightUpSum, rightDownDiff, n, 0);
      return count;
    }


    private void helpSolve(boolean[] pos,boolean[] rightUpSum, boolean[] rightDownDiff , int n, int l){
      if(l == n){
        count++;
        return;
      }
      for(int i = 0 ; i < n; i ++){
        if(! pos[i] && !rightUpSum[i + l] && !rightDownDiff[i - l + n]){
          pos[i] = true;
          rightUpSum[i+l] = true;
          rightDownDiff[i - l + n] = true;
          helpSolve(pos, rightUpSum, rightDownDiff, n, l+1);
          pos[i] = false;
          rightUpSum[i+l] = false;
          rightDownDiff[i - l + n] = false;
        }
      }
    }
}
