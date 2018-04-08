import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String input){
      if (input == null || input.length() == 0) return new ArrayList<Integer>();
      HashMap<Integer, List<Integer>> dpMap = new HashMap<Integer, List<Integer>>();
      return dpHelper(input, 0, input.length(), dpMap);
    }

    private List<Integer> dpHelper(String s, int start, int end, HashMap<Integer, List<Integer>> dpMap) {
      if (dpMap.containsKey(start * (s.length() + 1) + end)) return dpMap.get(start * (s.length() + 1) + end);
      List<Integer> ans = new ArrayList<Integer>();
      boolean singleNumber = true;
      for (int i = start; i < end ; i++) {
        if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
          singleNumber = false;
          computeAndAddToAns(ans, diffWaysToCompute(s.substring(start, i)), s.charAt(i), diffWaysToCompute(s.substring(i + 1, end)));
        }
      }
      if (singleNumber) {
        int thisNum = 0;
        for (int i = start; i < end ; i++) {
          thisNum *= 10;
          thisNum += s.charAt(i) - '0';
        }
        ans.add(thisNum);
      }
      dpMap.put(start * (s.length() + 1) + end, ans);
      return ans;
    }

    private void computeAndAddToAns(List<Integer> ans, List<Integer> leftOperands, char operation, List<Integer> rightOperands) {
      for (int i = 0; i < rightOperands.size(); i++) {
        for (int j = 0; j < leftOperands.size(); j++) {
          ans.add(computeExpression(leftOperands.get(j), operation, rightOperands.get(i)));
        }
      }
    }

    private int computeExpression(int a, char operation, int b) {
      if (operation == '+') return a + b;
      if (operation == '-') return a - b;
      if (operation == '*') return a * b;
      return 0;
    }

}
