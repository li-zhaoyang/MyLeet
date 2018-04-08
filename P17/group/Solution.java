import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> res = new ArrayList();
      if (digits == null || digits.length() == 0) return res;
      char[] tempCharArray = new char[0];
      helper(res, tempCharArray, digits, 0);
      return res;
    }
    public void helper(List<String> ans, char[] tempCharArray, String digits, int i) {
      if (i == digits.length()){
        ans.add(new String(tempCharArray));
        return;
      }
      String[] letterStringInNum = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      int thisNum = digits.charAt(i) - '0';
      for (int j = 0; j < letterStringInNum[thisNum].length() ; j++) {
        char[] newTempCharArray = Arrays.copyOf(tempCharArray, tempCharArray.length + 1);
        newTempCharArray[tempCharArray.length] = letterStringInNum[thisNum].charAt(j);
        helper(ans, newTempCharArray, digits, i + 1);
       }
    }
    
}
