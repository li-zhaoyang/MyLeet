import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      List<Integer> thisAnsItem = new ArrayList<Integer>();
      helper(ans, thisAnsItem, n);

      List<List<String>> ansString = new ArrayList<List<String>>();
      for (int i = 0; i < ans.size(); i++) {
        thisAnsItem = ans.get(i);
        List<String> thisStringList = new ArrayList<String>();
        for (int j = 0; j < thisAnsItem.size(); j++) {
          thisStringList.add(lineString(thisAnsItem.get(j), n));
        }
        ansString.add(thisStringList);
      }

      return ansString;
    }

    private void helper(List<List<Integer>> ans, List<Integer> thisAnsItem, int n) {
      int thisLineNum = thisAnsItem.size();
      if (thisLineNum == n) {
        ans.add(thisAnsItem);
        return;
      }
      for (int i = 0; i < n; i++) {
        if (checkValid(thisAnsItem, i)) {
          List<Integer> thisAnsItemNew = new ArrayList<Integer>(thisAnsItem);
          thisAnsItemNew.add(i);
          helper(ans, thisAnsItemNew, n);
        }
      }
    }

    private boolean checkValid(List<Integer> thisAnsItem, int col) {
      int row = thisAnsItem.size();
      for (int i = 0; i < row; i++) {
        int thisQueenCol = thisAnsItem.get(i);
        if (col == thisQueenCol)  return false;
        if (col + row == thisQueenCol + i)  return false;
        if (col - row == thisQueenCol - i)  return false;
      }
      return true;
    }

    private String lineString(int pos, int n) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < n; i ++) {
        if (i == pos) {
          sb.append('Q');
        } else {
          sb.append('.');
        }
      }
      return sb.toString();
    }


}
