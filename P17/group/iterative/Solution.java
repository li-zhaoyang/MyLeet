import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList();
      String[] letterStringInNum = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      for (int i = 0 ; i < digits.length(); i++){
        List<String> thisAns = new ArrayList();
        int thisNum = digits.charAt(i) - '0';
        if(result.size() == 0)
          for (int j = 0; j < letterStringInNum[thisNum].length() ; j++)
            thisAns.add(Character.toString(letterStringInNum[thisNum].charAt(j)));
        else
          for (int j = 0; j < letterStringInNum[thisNum].length() ; j++)
            for(int k = 0; k < result.size(); k++)
              thisAns.add( (new StringBuffer(result.get(k))).append(letterStringInNum[thisNum].charAt(j)).toString() );
        result = thisAns;
      }
      return result;
    }
}
