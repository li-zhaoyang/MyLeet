import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> ans = new ArrayList<List<String>>();
      if(n == 0)  return ans;
      List<Integer> pos = new ArrayList<Integer>();
      List rightUpSum = new ArrayList<Integer>();
      List rightDownDiff = new ArrayList<Integer>();
      helpSolve(ans, pos, rightUpSum, rightDownDiff, n);
      return ans;
    }

    private void helpSolve(List<List<String>> ans, List<Integer> pos,List rightUpSum, List rightDownDiff , int n){
      int l = pos.size();
      if(l == n){
        char[] thisLine = new char[n];
        for(int i = 0 ; i < n; i ++){
          thisLine[i] = '.';
        }
        List<String> thisAns = new ArrayList<String>();
        for(int i = 0 ; i < n; i ++){
          int thisPos = pos.get(i);
          thisLine[thisPos] = 'Q';
          thisAns.add(new String(thisLine));
          thisLine[thisPos] = '.';
        }
        ans.add(thisAns);
        return ;
      }

      for(int i = 0 ; i < n; i ++){
        if(! pos.contains( (Integer) i) && !rightUpSum.contains((Integer) (i + l)) && !rightDownDiff.contains((Integer) (i - l))){
          // List<Integer> thisPos = new ArrayList<Integer>(pos);
          // List<Integer> thisRightUpSum = new ArrayList<Integer>(rightUpSum);
          // List<Integer> thisRightDownDiff = new ArrayList<Integer>(rightDownDiff);
          pos.add(i);
          rightUpSum.add(i + l);
          rightDownDiff.add(i - l);
          helpSolve(ans, pos, rightUpSum, rightDownDiff, n);
          pos.remove((Integer) i);
          rightUpSum.remove((Integer) (i + l));
          rightDownDiff.remove((Integer) (i - l));
        }
      }

    }
}
