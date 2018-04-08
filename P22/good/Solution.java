import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> bracketLists = new ArrayList();
      StringBuffer lb = new StringBuffer("(");
      StringBuffer rb = new StringBuffer(")");
      StringBuffer str = new StringBuffer();
      writeS(bracketLists, str, 0, 0, n, lb, rb);
      return bracketLists;
    }

    void writeS(List<String> bracketLists, StringBuffer str, int left, int right, int n,StringBuffer lb, StringBuffer rb){
      if(right  == n){
        String s = new String(str);
        bracketLists.add(s);
        return;
      }
      StringBuffer str1 = new StringBuffer(str);
      if(left < n) writeS(bracketLists, str.append(lb), left+1, right, n, lb, rb);
      if(right<left)  writeS(bracketLists, str1.append(rb), left, right+1, n, lb, rb);

    }
}
